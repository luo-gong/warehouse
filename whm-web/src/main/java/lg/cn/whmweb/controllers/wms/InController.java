package lg.cn.whmweb.controllers.wms;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.*;
import lg.cn.whmbms.entity.Product;
import lg.cn.whmbms.entity.ProductType;
import lg.cn.whmbms.entity.Storehouse;
import lg.cn.whmbms.service.*;
import lg.cn.whmoms.entity.Order;
import lg.cn.whmoms.service.OrderService;
import lg.cn.whmsms.entity.Stock;
import lg.cn.whmsms.service.StockService;
import lg.cn.whmwms.entity.Inwarehouse;
import lg.cn.whmwms.entity.Outwarehouse;
import lg.cn.whmwms.service.InwarehouseService;
import lg.cn.whmwms.service.InwarehouseTypeService;
import lg.cn.whmwms.service.LibrarstateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping(value = "inhouse")
public class InController {
    /* @Reference
     BillService billService;*/
    @Reference
    InwarehouseService inwarehouseService;

    @Reference(interfaceClass = InwarehouseTypeService.class)
    InwarehouseTypeService inwarehouseTypeService;

    CommonResult commonResult;

    @Reference
    LibrarstateService librarstateService;

    @Reference
    ProductService productService;

    @Reference
    SupplierService supplierService;

    @Reference
    StockService stockService;

    @Reference
    StorehouseService storehouseService;

    @Reference
    OrderService orderService;

    @Reference
    ProductTypeService productTypeService;

    @Reference
    MeteringService meteringService;

    /**
     * 入库管理数据展示
     *
     * @param inwarehouseTypeId
     * @param orderAuditorState
     * @param page
     * @param model
     * @return
     */
    @RequestMapping
    public String inhouseHtml(@RequestParam(required = false) String inwarehouseTypeId,
                              @RequestParam(required = false) String orderAuditorState,
                              Page<Inwarehouse> page, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("inwarehouseTypeId", inwarehouseTypeId);
        map.put("orderAuditorState", orderAuditorState);
        IPage iPage = inwarehouseService.getPage(map, page);
        map.put("inwarehouseTypes", inwarehouseTypeService.list());
        map.put("librarstates", librarstateService.list());
        map.put("inwarehouses", iPage);
        map.put("pages", new String[(int) iPage.getPages()]);
        model.addAllAttributes(map);
        System.out.println("InController>>>>>>>>>>inhouseHtml");
        return "inhouse/inhouse";
    }

    /**
     * 查看入库单
     */
    @GetMapping("inhouseFindHtml/{inwarehouseId}")
    @ResponseBody
    public Object inhouseFindHtml(@PathVariable Integer inwarehouseId) {
        System.out.println("InController>>>>>>>>>>findInHouseById");
        return inwarehouseService.getById(inwarehouseId);
    }

    /**
     * 跳转到编辑入库单页面
     *
     * @param inwarehouseId
     * @return
     */
    @GetMapping("updateInHouseHtml")
    public Object updateInHouseHtml(@RequestParam Integer inwarehouseId, Model model) {
        Map map = new HashMap();
        map.put("inwarehouseTypes", inwarehouseTypeService.list());
        map.put("inwarehouse", inwarehouseService.getById(inwarehouseId));
        map.put("suppliers", supplierService.list());
        model.addAllAttributes(map);
        System.out.println("InController>>>>>>>>>>updateInHouseHtml");
        return "inhouse/inhouseUpdate";
    }

    /**
     * 修改入库单
     *
     * @return
     */
    @PostMapping("updateInHouse")
    public Object updateInHouse(InwarehouseUpdateTo inwarehouseUpdateTo) {
        //根据orderCode查询order
        Map map = new HashMap();
        Order order = orderService.getById(inwarehouseUpdateTo.getOrderId());
        //对订单总金额进行增减
        BigDecimal bigDecimal = new BigDecimal(order.getOrderPriceSum().toString());
        bigDecimal = bigDecimal.subtract(order.getOrderProductPriceSum());
        bigDecimal = bigDecimal.add(inwarehouseUpdateTo.getOrderProductPriceSum());
        inwarehouseUpdateTo.getOrder().setOrderPriceSum(bigDecimal);
        //根据orderCode更新OrderPriceSum
        inwarehouseUpdateTo.getOrder().setOrderCode(inwarehouseUpdateTo.getOrderCode());
        inwarehouseUpdateTo.getOrder().setOrderPriceSum(bigDecimal);
        if (orderService.updateOrderPriceSumByOrdercode(inwarehouseUpdateTo.getOrder())) {
            //根据产品id和库位修改库存表
            map = new HashMap();
            map.put("product_id", inwarehouseUpdateTo.getProductId());
            map.put("storehouse_id", inwarehouseUpdateTo.getStorehouseId());
            List<Stock> stocks = (List<Stock>) stockService.listByMap(map);
            if (null == stocks || stocks.size() < 1) {
                Stock stock = new Stock();
                stock.setStockNumber(order.getOrderNumber() - inwarehouseUpdateTo.getOrderNumber());
                BeanUtil.copyProperties(inwarehouseUpdateTo, stock, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                BeanUtil.copyProperties(productService.getById(stock.getProductId()), stock, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                BeanUtil.copyProperties(productTypeService.getById(stock.getProductTypeId()), stock, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                BeanUtil.copyProperties(meteringService.getById(productService.getById(stock.getProductId()).getMeteringIdStore()), stock, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                stockService.save(stock);
            } else {
                Stock stock = stocks.get(0);
                stock.setStockNumber(stock.getStockNumber() - order.getOrderNumber() + inwarehouseUpdateTo.getOrderNumber());
                stockService.updateById(stock);
            }
            BeanUtil.copyProperties(inwarehouseUpdateTo, order, true,
                    CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            BeanUtil.copyProperties(inwarehouseUpdateTo.getOrder(), order, true,
                    CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            if (orderService.updateById(order)) {
                Inwarehouse inwarehouse = inwarehouseService.getById(inwarehouseUpdateTo.getInwarehouseId());
                BeanUtil.copyProperties(inwarehouseUpdateTo, inwarehouse, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                BeanUtil.copyProperties(inwarehouseUpdateTo.getOrder(), inwarehouse, true,
                        CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                inwarehouseService.updateById(inwarehouse);
            }
        }


        System.out.println("InController>>>>>>>>>>updateInHouse");
        return "redirect:/inhouse";

    }

    /**
     * 删除入库单
     *
     * @param inwarehouseId
     * @return
     */
    @GetMapping("deleteInHouse/{inwarehouseId}")
    @ResponseBody
    public Object deleteInHouse(@PathVariable Integer inwarehouseId) {
        System.out.println("InController>>>>>>>>>>deleteInHouse");
        Inwarehouse inwarehouse = new Inwarehouse();
        inwarehouse.setInwarehouseId(inwarehouseId);
        inwarehouse.setInwarehouseIsdelete(1);
        commonResult = new CommonResult();
        if (inwarehouseService.updateById(inwarehouse)) {
            return commonResult.success("删除成功");
        }
        return commonResult.validateFailed("删除失败");
    }

//新增入库单开始

    /**
     * 跳转到新增出库单页面
     *
     * @return
     */
    @GetMapping("inhouseaddHtml")
    public String inhouseaddHtml(ModelMap modelMap) {
        modelMap.addAttribute("inwarehouseTypes", inwarehouseTypeService.list());
        modelMap.addAttribute("suppliers", supplierService.list());
        System.out.println("inController>>>>>>>>>>inhouseaddHtml");
        return "inhouse/inhouseadd";
    }

    /**
     * @param supplierCode
     * @return
     */
    @GetMapping("supplierCodeSelect")
    @ResponseBody
    public Object supplierCodeSelect(String supplierCode) {
        return supplierService.getSupplierByCode(supplierCode);
    }

    BigDecimal sum = null;

    /**
     * 新增入库单
     *
     * @return
     */
    @PostMapping("inhouseadd")
    public String inhouseadd(InhouseaddTo inhouseaddTo) {
        Integer orderId = null;
        if (StringUtils.isEmpty(inhouseaddTo.getInwarehouseCode()))
            inhouseaddTo.setInwarehouseCode(UUID.randomUUID().toString());
        sum = new BigDecimal("0");
        inhouseaddTo.setOrders(inhouseaddTo
                .getOrders()
                .stream()
                .filter(order -> order.getProductId() != null).collect(Collectors.toList()));
        inhouseaddTo.getOrders().forEach(order -> {
            sum = sum.add(new BigDecimal(order.getOrderProductPriceSum().toString()));
        });

        inhouseaddTo.getOrders().forEach(order -> {
            Inwarehouse inwarehouse = new Inwarehouse();
            order.setOrderPriceSum(sum);
            order.setOrderState(6);
            order.setOrderIspayment(0);
//            order.setOrderInlibrary(order.getOrderNumber());
            order.setOrderIsreturngoods(0);
            order.setOrderAuditorState(1);
            order.setStorehouseName(storehouseService.getById(order.getStorehouseId()).getStorehouseName());
            //复制旧的属性过来，忽略null属性，忽略null值，有值的以新的为主，null的则以旧为主
            BeanUtil.copyProperties(inhouseaddTo, order, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            //新增订单
            order = orderService.insertOrder(order);
            BeanUtil.copyProperties(inhouseaddTo, inwarehouse, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            BeanUtil.copyProperties(order, inwarehouse, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            //新增出库单
            inwarehouseService.save(inwarehouse);
            //库存修改
            Map<String, Object> map = new HashMap<>();
            map.put("product_id", order.getProductId());
            map.put("storehouse_id", order.getStorehouseId());
            List<Stock> stocks = (List<Stock>) stockService.listByMap(map);
            Stock stock = new Stock();
            if (null != stocks && stocks.size() > 0) {
                stock = stocks.get(0);
                stock.setStockNumber(stock.getStockNumber() + order.getOrderNumber());
                stockService.updateById(stock);//根据id修改库存数量
            } else {
                BeanUtil.copyProperties(order, stock, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                stock.setStockNumber(order.getOrderNumber());
                stockService.save(stock);
            }
        });
        log.info("inController>>>>>>>>>inhouseadd");
        return "redirect:/inhouse";
    }

    /**
     * 查询商品
     *
     * @return
     */
    @GetMapping("productByProduct")
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
        List<Storehouse> storehouses = storehouseService.list();
        //遍历产品集合进行业务增改
        products.forEach(product1 -> {
            ProductStorehouseTo productStorehouseTo = new ProductStorehouseTo();
            BeanUtil.copyProperties(product1, productStorehouseTo, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
            List<StorehouseTo> storehouselist = new ArrayList<>();
            storehouses.forEach(storehouse -> {
                StorehouseTo storehouseTo = new StorehouseTo();
                BeanUtil.copyProperties(storehouse, storehouseTo, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                storehouselist.add(storehouseTo);
            });
            productStorehouseTo.setStorehouselist(storehouselist);
            productStorehouseTos.add(productStorehouseTo);
        });
        return productStorehouseTos;
    }
    //新增入库单结束

}
