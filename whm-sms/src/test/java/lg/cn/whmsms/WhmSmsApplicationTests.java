package lg.cn.whmsms;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.cn.to.LedgerTo;
import lg.cn.whmsms.entity.Ledger;
import lg.cn.whmsms.entity.Stock;
import lg.cn.whmsms.service.LedgerService;
import lg.cn.whmsms.service.StockService;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
class WhmSmsApplicationTests {

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    LedgerService ledgerService;

    @Autowired
    StockService stockService;

    @Test
    void contextLoads() throws JsonProcessingException {
        Page<Ledger> page = new Page<>();
        page.setSize(2);
        System.out.println(objectMapper.writeValueAsString(ledgerService.getLedgerPage(null, page)));
    }

    @Test
    void easyPoi() throws IOException {

        Workbook sheets = ExcelExportUtil.
                exportExcel(
                        new ExportParams("嘿嘿", "第一个easypoi"),
                        Stock.class, stockService.list());
        FileOutputStream fos = new FileOutputStream("D:\\Users\\luogong\\Desktop\\read.xls");
        sheets.write(fos);
    }

}
