package lg.cn.whmweb.controllers.oms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.ReturnSaleTo;
import lg.cn.to.SaleTo;
import lg.cn.whmoms.entity.ReturnSale;
import lg.cn.whmoms.entity.Sale;
import lg.cn.whmoms.service.OrderAuditorService;
import lg.cn.whmoms.service.ReturnSaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("salereturn")
@Slf4j
public class SalereturnController {

    @Reference
    ReturnSaleService returnSaleService;

    @Reference
    OrderAuditorService orderAuditorService;

    @GetMapping("salereturnHtml")
    public String salereturnHtml(ReturnSaleTo returnSaleTo, Page<ReturnSale> page, ModelMap modelMap) {
        IPage<ReturnSale> returnSaleIPage = returnSaleService.getSalePage(page, returnSaleTo);
        modelMap.addAttribute("orderAuditors", orderAuditorService.list());
        modelMap.addAttribute("returnSales", returnSaleIPage.getRecords());
        modelMap.addAttribute("page", new String[(int) returnSaleIPage.getPages()]);
        modelMap.addAttribute("returnSaleTo", returnSaleTo);
        log.info("SalereturnController>>>salereturnHtml");
        return "oms/salereturn";
    }


    @GetMapping("findSalereturn/{id}")
    public String findSalereturn(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("deleteSalereturn/{id}")
    public String deleteSalereturn(@PathVariable Integer id) {
        return null;
    }
}
