package lg.cn.whmweb.controllers.oms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.ReturngoodsTo;
import lg.cn.whmoms.entity.ReturnGoods;
import lg.cn.whmoms.service.OrderAuditorService;
import lg.cn.whmoms.service.ReturnGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "returngoods")
public class ReturngoodController {

    @Reference
    OrderAuditorService orderAuditorService;
    @Reference
    ReturnGoodsService returnGoodsService;

    @GetMapping("returngoodHtml")
    public String returngoodsHtml(ReturngoodsTo returngoodsTo,
                                  Page<ReturnGoods> page,
                                  ModelMap modelMap) {
        IPage<ReturnGoods> returnGoodsIPage = returnGoodsService.getReturnGoodsPage(page, returngoodsTo);
        modelMap.addAttribute("orderAuditors", orderAuditorService.list());
        modelMap.addAttribute("returnGoodss", returnGoodsIPage.getRecords());
        modelMap.addAttribute("page", new String[(int) returnGoodsIPage.getPages()]);
        modelMap.addAttribute("returngoodsTo", returngoodsTo);
        return "oms/returngood";
    }


    @GetMapping("deleteBuy/{id}")
    public String deleteBuy(@PathVariable Integer id) {
        return null;
    }
}
