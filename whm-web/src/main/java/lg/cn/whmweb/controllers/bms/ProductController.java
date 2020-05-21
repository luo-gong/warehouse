package lg.cn.whmweb.controllers.bms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lg.cn.whmbms.entity.Product;
import lg.cn.whmbms.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {


    @Reference
    ProductService productService;


    /**
     * 查询商品返回到 whm-web outhouseadd.html
     *
     * @param product
     * @param modelMap
     * @return
     */
    @GetMapping("/outhouseadd/productFind")
    @ResponseBody
    public String productFind(Product product, ModelMap modelMap) {
        List<Product> products = null;
        if (null != products) {
            QueryWrapper queryWrapper = new QueryWrapper(Product.class);
            if (!StringUtils.isEmpty(product.getProductName()))
                queryWrapper.like("product_name", product.getProductName());
            if (!StringUtils.isEmpty(product.getProductCode()))
                queryWrapper.like("product_code", product.getProductCode());
            productService.list(queryWrapper);
        } else {
            products = productService.list();
        }
        modelMap.addAttribute("products", products);
        return "outhouseadd";
    }
}
