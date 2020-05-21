package lg.cn.whmwms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.whmwms.entity.Inwarehouse;
import lg.cn.whmwms.entity.InwarehouseType;
import lg.cn.whmwms.entity.Outwarehouse;
import lg.cn.whmwms.entity.OutwarehouseType;
import lg.cn.whmwms.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WhmWmsApplicationTests {
    @Autowired
    BillService billService;

    @Autowired
    InwarehouseTypeService inwarehouseTypeService;

    @Autowired
    InwarehouseService inwarehouseService;

    @Autowired
    OutwarehouseService outwarehouseService;

    @Autowired
    OutwarehouseTypeService outwarehouseTypeService;

    @Test
    void contextLoads() {
        log.info("BillService>>>>>>>>>>>>>>>>>>" + billService.getById(1));
    }

    @Test
    void inwarehouse_type() {
        log.info("入库类型》》》》" + inwarehouseTypeService.list());
    }

    @Test
    void inwarehousePage() {
        Page<Inwarehouse> inwarehousePage = new Page<>();
        inwarehousePage.setSize(10);

        log.info("入库数据分页》》》》" + inwarehouseService.page(inwarehousePage).getRecords());
    }

    @Test
    void outwarehousePage() {
        Page<Outwarehouse> inwarehousePage = new Page<>();
        log.info("出库数据分页》》》》" + outwarehouseService.page(inwarehousePage).getRecords());
    }

    @Test
    void outwarehouseType() {
        log.info("出库类型》》》》" + outwarehouseTypeService.list());
    }
}
