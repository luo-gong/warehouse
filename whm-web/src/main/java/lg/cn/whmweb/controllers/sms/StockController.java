package lg.cn.whmweb.controllers.sms;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.LedgerTo;
import lg.cn.to.StockTo;
import lg.cn.whmbms.service.WarehouseService;
import lg.cn.whmsms.entity.Ledger;
import lg.cn.whmsms.entity.Stock;
import lg.cn.whmsms.service.StockService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 库存清单
 */
@Controller
@RequestMapping("stock")
public class StockController {

    @Reference
    StockService stockService;

    @Reference
    WarehouseService warehouseService;


    @GetMapping("stockHtml")
    public String stockHtml(Page<Stock> page, StockTo stockTo,
                            ModelMap modelMap,
                            @RequestParam(required = false) String easypoi,
                            HttpServletRequest request) {
        IPage<Stock> stockIPage = stockService.getStockPage(stockTo, page);
        modelMap.addAttribute("stocks", stockIPage.getRecords());
        modelMap.addAttribute("stockTo", stockTo);
        modelMap.addAttribute("page", new String[(int) stockIPage.getPages()]);
        modelMap.addAttribute("warehouses", warehouseService.list());
        modelMap.addAttribute("current", stockIPage.getCurrent());

        if ("导出".equals(easypoi)) {
            request.setAttribute("stocks", stockIPage.getRecords());
            return "forward:/stock/easypoi";
        }

        return "sms/inventory";
    }

    @RequestMapping("easypoi")
    public void export(HttpServletResponse httpServletResponse, HttpServletRequest request) throws IOException {
        String fileName = "stock.xls";
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("库存");
        Workbook sheets = ExcelExportUtil.exportExcel(exportParams, Stock.class, (List<Stock>) request.getAttribute("stocks"));
        httpServletResponse.reset();
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("content-disposition", "attachment;filename=" + new String(fileName.getBytes("ISO8859-1")));
        httpServletResponse.setHeader("filename", fileName);
        sheets.write(httpServletResponse.getOutputStream());
        httpServletResponse.getOutputStream().flush();
    }
}
