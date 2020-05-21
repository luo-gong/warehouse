package lg.cn.whmweb.controllers.oms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.BuyTo;
import lg.cn.to.SaleTo;
import lg.cn.whmoms.entity.Buy;
import lg.cn.whmoms.entity.Sale;
import lg.cn.whmoms.service.OrderAuditorService;
import lg.cn.whmoms.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sale")
@Slf4j
public class SaleController {
    @Reference
    SaleService saleService;
    @Reference
    OrderAuditorService orderAuditorService;

    @GetMapping("saleHtml")
    public String saleHtml(SaleTo saleTo, Page<Sale> page, ModelMap modelMap) {
        IPage<Sale> saleIPage = saleService.getSalePage(page, saleTo);
        modelMap.addAttribute("orderAuditors", orderAuditorService.list());
        modelMap.addAttribute("sales", saleIPage.getRecords());
        modelMap.addAttribute("page", new String[(int) saleIPage.getPages()]);
        modelMap.addAttribute("saleTo", saleTo);
        log.info("SaleController>>>saleHtml");

        return "oms/saleindex";
    }

    @GetMapping("addSaleHtml")
    public String addSaleHtml() {
        return null;
    }

    @PostMapping("addSale")
    public String addSale() {
        return null;
    }

    @GetMapping("updateSaleHtml")
    public String updateSaleHtml() {
        return null;
    }

    @PostMapping("updateSale")
    public String updateSale() {
        return null;
    }

    @GetMapping("deleteSale/{id}")
    public String deleteSale(@PathVariable Integer id) {
        return null;
    }
}
