package lg.cn.whmweb.controllers.wms;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.*;
import lg.cn.whmbms.entity.Product;
import lg.cn.whmbms.service.CustomerService;
import lg.cn.whmbms.service.ProductService;
import lg.cn.whmbms.service.StorehouseService;
import lg.cn.whmoms.entity.Order;
import lg.cn.whmoms.service.OrderService;
import lg.cn.whmsms.entity.Stock;
import lg.cn.whmsms.service.StockService;
import lg.cn.whmwms.entity.Outwarehouse;
import lg.cn.whmwms.service.LibrarstateService;
import lg.cn.whmwms.service.OutwarehouseService;
import lg.cn.whmwms.service.OutwarehouseTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("outhouse")
public class OutController {
    CommonResult commonResult;

    @Reference
    OutwarehouseTypeService outwarehouseTypeService;
    @Reference
    OutwarehouseService outwarehouseService;
    @Reference
    LibrarstateService librarstateService;

    @Reference
    ProductService productService;

    @Reference
    StorehouseService storehouseService;

    @Reference
    StockService stockService;

    @Reference
    OrderService orderService;

    @Reference
    CustomerService customerService;


//    ThreadLocal<Map<Integer, ProductOrderTo>> productOrderToThreadLocal;


    @GetMapping("outhouseHtml")
    public String outhouseHtml(@RequestParam(required = false) String outwarehouseTypeId,
                               @RequestParam(required = false) String orderAuditorState,
                               Page<Outwarehouse> page, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("outwarehouseTypeId", outwarehouseTypeId);
        map.put("orderAuditorState", orderAuditorState);
        IPage iPage = outwarehouseService.getPage(map, page);
        map = new HashMap();
        map.put("outwarehouseTypes", outwarehouseTypeService.list());
        map.put("librarstates", librarstateService.list());
        map.put("outwarehouses", iPage);
        map.put("page", new String[(int) iPage.getPages()]);
        map.put("outwarehouseTypeId", outwarehouseTypeId);
        map.put("orderAuditorState", orderAuditorState);
        model.addAllAttributes(map);
        System.out.println("OutController>>>>>>>>>>outhouseHtml");
        return "outwarehouse/outhouse";
    }


    /**
     * 删除出库单
     */
    @GetMapping("outhouseDelete/{outwarehouseId}")
    @ResponseBody
    public Object outhouseDelete(@PathVariable Integer outwarehouseId) {
        Outwarehouse outwarehouse = new Outwarehouse();
        outwarehouse.setOutwarehouseId(outwarehouseId);
        outwarehouse.setOutwarehouseIsdelete(1);
        commonResult = new CommonResult();
        if (outwarehouseService.updateById(outwarehouse)) {
            return commonResult.success("删除成功");
        }
        return commonResult.validateFailed("删除失败");
    }

    /**
     * 查看
     */
    @GetMapping("outhouseFindHtml/{outwarehouseId}")
    @ResponseBody
    public Object outhouseFind(@PathVariable String outwarehouseId) {
        return outwarehouseService.getById(outwarehouseId);
    }


    //出库单编辑开始

    /**
     * 跳转到编辑出库单页面
     *
     * @param model
     * @param outwarehouseId 出库单id
     * @return
     */
    @GetMapping("outhouseUpdateHtml")
    public String outhouseUpdateHtml(Integer outwarehouseId, Model model) {
        Map map = new HashMap();
        map.put("outwarehouseTypes", outwarehouseTypeService.list());
        map.put("outwarehouse", outwarehouseService.getById(outwarehouseId));
        map.put("customers", customerService.list());
        model.addAllAttributes(map);
        System.out.println("OutController>>>>>>>>>>outhouseUpdateHtml");
        return "outwarehouse/outhouseUpdate";
    }


    /**
     * 对产品进行选中时进行商品的添加
     * 取消选中时对商品进行删除
     *
     * @return
     */
  /*  @RequestMapping("productOrderToThreadLocal")
    @ResponseBody
    public Object productOrderToThreadLocalAdd(ProductOrderTo productOrderTo) {

        Map<Integer, ProductOrderTo> map = productOrderToThreadLocal.get();
        if (null == map) {
            map = new HashMap<>();
            map.put(productOrderTo.getOrderId(), productOrderTo);
        }
        return null;
    }*/


    /**
     * 编辑出库单
     *
     * @return
     */
    @PostMapping("outhouseUpdate")
    public String outhouseUpdate(OutwarehouseUpdateTo outwarehouseUpdateTo) {
        //根据orderCode查询order
        Map map = new HashMap();
        Order order = orderService.getById(outwarehouseUpdateTo.getOrderId());
        //对订单总金额进行增减
        BigDecimal bigDecimal = new BigDecimal(order.getOrderPriceSum().toString());
        bigDecimal = bigDecimal.subtract(order.getOrderProductPriceSum());
        bigDecimal = bigDecimal.add(outwarehouseUpdateTo.getOrderProductPriceSum());
        outwarehouseUpdateTo.getOrder().setOrderPriceSum(bigDecimal);
        //根据orderCode更新OrderPriceSum
        outwarehouseUpdateTo.getOrder().setOrderCode(outwarehouseUpdateTo.getOrderCode());
        outwarehouseUpdateTo.getOrder().setOrderPriceSum(bigDecimal);
        if (orderService.updateOrderPriceSumByOrdercode(outwarehouseUpdateTo.getOrder())) {
            //根据产品id和库位修改库存表
            map = new HashMap();
            map.put("product_id", outwarehouseUpdateTo.getProductId());
            map.put("storehouse_id", outwarehouseUpdateTo.getStorehouseId());
            List<Stock> stocks = (List<Stock>) stockService.listByMap(map);
            Stock stock = stocks.get(0);
            stock.setStockNumber(stock.getStockNumber() + order.getOrderNumber() - outwarehouseUpdateTo.getOrderNumber());
            if (stockService.updateById(stock)) {
                BeanUtil.copyProperties(outwarehouseUpdateTo, order, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                BeanUtil.copyProperties(outwarehouseUpdateTo.getOrder(), order, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                if (orderService.updateById(order)) {
                    Outwarehouse outwarehouse = outwarehouseService.getById(outwarehouseUpdateTo.getOutwarehouseId());
                    BeanUtil.copyProperties(outwarehouseUpdateTo, outwarehouse, true,
                            CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                    BeanUtil.copyProperties(outwarehouseUpdateTo.getOrder(), outwarehouse, true,
                            CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                    outwarehouseService.updateById(outwarehouse);
                }
            }
        }
        return "redirect:/outhouse/outhouseHtml";
    }
    //出库单编辑结束


    //出库单新增开始

    /**
     * 跳转到新增出库单页面
     *
     * @return
     */
    @GetMapping("outhouseaddHtml")
    public String outhouseaddHtml(ModelMap modelMap) {
        modelMap.addAttribute("outwarehouseTypes", outwarehouseTypeService.list());
        modelMap.addAttribute("customers", customerService.list());
        System.out.println("OutController>>>>>>>>>>outhouseaddHtml");
        return "outwarehouse/outhouseadd";
    }


    @GetMapping("customerCodeSelect")
    @ResponseBody
    public Object customerCodeSelect(String customerCode) {
        return customerService.getCutomerByCode(customerCode);
    }

    BigDecimal sum = null;

    /**
     * 新增出库单
     *
     * @return
     */
    @PostMapping("outhouseadd")
    @Transactional
    public String outhouseadd(OuthouseaddTo outhouseaddTo) {
        Integer orderId = null;
        if (StringUtils.isEmpty(outhouseaddTo.getOutwarehouseCode()))
            outhouseaddTo.setOutwarehouseCode(UUID.randomUUID().toString());
        sum = new BigDecimal("0");
        outhouseaddTo.setOrders(outhouseaddTo
                .getOrders()
                .stream()
                .filter(order -> order.getProductId() != null).collect(Collectors.toList()));
        outhouseaddTo.getOrders().forEach(order -> {
            sum = sum.add(new BigDecimal(order.getOrderProductPriceSum().toString()));
        });

        outhouseaddTo.getOrders().forEach(order -> {
            Outwarehouse outwarehouse = new Outwarehouse();
            order.setOrderPriceSum(sum);
            order.setOrderState(6);
            order.setOrderIspayment(0);
            order.setOrderOutlibrary(order.getOrderNumber());
            order.setOrderIsreturngoods(0);
            order.setOrderAuditorState(1);
            order.setStorehouseName(stockService.getById(order.getStorehouseId()).getStorehouseName());//注意传递过来的是stockId;并不是storehouseId
            order.setStorehouseId(stockService.getById(order.getStorehouseId()).getStorehouseId());//注意传递过来的是stockId;并不是storehouseId
            //复制旧的属性过来，忽略null属性，忽略null值，有值的以新的为主，null的则以旧为主
            BeanUtil.copyProperties(outhouseaddTo, order, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            //新增订单
            order = orderService.insertOrder(order);
            BeanUtil.copyProperties(outhouseaddTo, outwarehouse, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            BeanUtil.copyProperties(order, outwarehouse, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            //新增出库单
            outwarehouseService.save(outwarehouse);
            //库存修改
            Stock stock = stockService.getById(order.getStorehouseId());
            stock.setStockNumber(stock.getStockNumber() - order.getOrderNumber());
            stockService.updateById(stock);//根据id修改库存数量
        });

        log.info("OutController>>>>>>>>>outhouseadd" + outhouseaddTo);
        return "redirect:/outhouse/outhouseHtml";
    }

    /**
     * 出库查询商品
     *
     * @return
     */
    @GetMapping("outhouseadd/productByProduct")
    @ResponseBody
    public Object productByProduct(Product product) {
        List<ProductStorehouseTo> productStorehouseTos = new ArrayList<>();
        List<Product> products = null;
        //查询产品集合
        if (null != product) {
            products = productService.getProductByProduct(product);
        } else {
            products = productService.list();
        }
        //遍历产品集合进行业务增改
        products.forEach(product1 -> {
            Map<String, Object> columnMap = new HashMap<>();
            ProductStorehouseTo productStorehouseTo = new ProductStorehouseTo();
            columnMap.put("product_id", product1.getProductId());
            List<Stock> stocks = (List<Stock>) stockService.listByMap(columnMap);
            List<StorehouseTo> storehouses = new ArrayList<>();
            if (null != stocks)
                stocks.forEach(stock -> {
                    StorehouseTo storehouseTo = new StorehouseTo();
                    BeanUtil.copyProperties(storehouseService.getById(stock.getStorehouseId()), storehouseTo,
                            true,
                            CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                    storehouseTo.setStockId(stock.getStockId());
                    storehouses.add(storehouseTo);
                  /*  Storehouse storehouse = new Storehouse();
                    BeanUtils.copyProperties(stock, storehouse);
                    storehouses.add(storehouse);*/
                });
            BeanUtil.copyProperties(product1, productStorehouseTo,
                    true,
                    CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            productStorehouseTo.setStorehouselist(storehouses);
            productStorehouseTos.add(productStorehouseTo);
        });
        return productStorehouseTos;
    }

    //出库单新增结束

    /**
     * 查看出库单
     *
     * @param outwarehouseId
     * @return
     */
    @GetMapping("findOutHouseById")
    @ResponseBody
    public Object findOutHouseById(@RequestParam Integer outwarehouseId) {
        System.out.println("InController>>>>>>>>>>findOutHouseById");
        return outwarehouseService.getById(outwarehouseId);
    }

    /* *//**
     * 展示出库单
     *
     * @param outwarehouseId
     * @return
     *//*
    @GetMapping("updateOutHouseHtml")
    @ResponseBody
    public Object updateOutHouseHtml(@RequestParam Integer outwarehouseId) {
        System.out.println("OutController>>>>>>>>>>updateOutHouseHtml");
        return outwarehouseService.getById(outwarehouseId);
    }*/
/*

    @PostMapping("updateOutHouse")
    @ResponseBody
    public Object updateOutHouse(@RequestBody Outwarehouse outwarehouse) {
        System.out.println("InController>>>>>>>>>>updateInHouse");
        if (outwarehouseService.updateById(outwarehouse)) {
            return commonResult.success("修改成功");
        }
        return commonResult.validateFailed("修改失败");

    }
*/

   /* @GetMapping("deleteOutHouse")
    @ResponseBody
    public Object deleteOutHouse(@RequestBody Integer outwarehouseId) {
        System.out.println("OutController>>>>>>>>>>deleteOutHouse");
        Outwarehouse outwarehouse = new Outwarehouse();
        outwarehouse.setOutwarehouseId(outwarehouseId);
        outwarehouse.setOutwarehouseIsDelete(1);
        if (outwarehouseService.updateById(outwarehouse)) {
            return commonResult.success("删除成功");
        }
        return commonResult.validateFailed("删除失败");
    }*/

}
