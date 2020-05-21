package lg.cn.whmweb.controllers.oms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.BuyTo;
import lg.cn.whmoms.entity.Buy;
import lg.cn.whmoms.entity.OrderAuditor;
import lg.cn.whmoms.service.BuyService;
import lg.cn.whmoms.service.OrderAuditorService;
import lg.cn.whmoms.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("buy")
@Slf4j
public class BuyController {

    @Reference
    BuyService buyService;

    @Reference
    OrderService orderService;

    @Reference
    OrderAuditorService orderAuditorService;//审核状态


    @GetMapping("buyHtml")
    public String buyHtml(BuyTo buyTo, Page<Buy> page, ModelMap modelMap) {
        IPage<Buy> buyIPage = buyService.getBuyPage(page, buyTo);
        modelMap.addAttribute("orderAuditors", orderAuditorService.list());
        modelMap.addAttribute("buys", buyIPage.getRecords());
        modelMap.addAttribute("page", new String[(int) buyIPage.getPages()]);
        modelMap.addAttribute("buyTo", buyTo);
        log.info("BuyController>>>buyHtml");
        return "oms/buyIndex";
    }

    @GetMapping("addBuyHtml")
    public String addBuyHtml() {
        return null;
    }

    @PostMapping("addBuy")
    public String addBuy() {
        return null;
    }

    @GetMapping("updateBuyHtml")
    public String updateBuyHtml() {
        return null;
    }

    @PostMapping("updateBuy")
    public String updateBuy() {
        return null;
    }

    @GetMapping("deleteBuy/{id}")
    public String deleteBuy(@PathVariable Integer id) {
        return null;
    }

}
