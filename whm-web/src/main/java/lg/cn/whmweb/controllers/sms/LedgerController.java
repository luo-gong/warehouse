package lg.cn.whmweb.controllers.sms;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.LedgerTo;
import lg.cn.whmbms.service.WarehouseService;
import lg.cn.whmsms.entity.Ledger;
import lg.cn.whmsms.entity.Stock;
import lg.cn.whmsms.service.LedgerService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "ledger")
public class LedgerController {

    @Reference
    LedgerService ledgerService;

    @Reference
    WarehouseService warehouseService;

    @GetMapping(value = "ledgerHtml")
    public String ledgerHtml(Page<Ledger> page,
                             LedgerTo ledgerTo,
                             ModelMap modelMap,
                             @RequestParam(required = false) String easypoi,
                             HttpServletRequest request) {
        IPage<Ledger> ledgerIPage = ledgerService.getLedgerPage(ledgerTo, page);
        modelMap.addAttribute("ledgers", ledgerIPage.getRecords());
        modelMap.addAttribute("ledgerTo", ledgerTo);
        modelMap.addAttribute("page", new String[(int) ledgerIPage.getPages()]);
        modelMap.addAttribute("warehouses", warehouseService.list());
        modelMap.addAttribute("current", ledgerIPage.getCurrent());

        if ("导出".equals(easypoi)) {
            request.setAttribute("ledgers", ledgerIPage.getRecords());
            return "forward:/ledger/easypoi";
        }
        return "sms/stockaccount";
    }

    @RequestMapping("easypoi")
    public void export(HttpServletResponse httpServletResponse, HttpServletRequest request) throws IOException {
        String fileName = "ledger.xls";
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("清单");
        Workbook sheets = ExcelExportUtil.exportExcel(exportParams, Ledger.class, (List<Ledger>) request.getAttribute("ledgers"));
        httpServletResponse.reset();
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes("ISO8859-1")));
        httpServletResponse.setHeader("filename", fileName);
        sheets.write(httpServletResponse.getOutputStream());
        httpServletResponse.getOutputStream().flush();
    }
}
