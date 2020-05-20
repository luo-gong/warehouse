package cn.lg.whmoms;

import cn.lg.whmoms.mapper.OrderMapper;
import cn.lg.whmoms.servicImpl.*;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.cn.to.BuyTo;
import lg.cn.to.ReturnSaleTo;
import lg.cn.to.ReturngoodsTo;
import lg.cn.to.SaleTo;
import lg.cn.whmoms.entity.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WhmOmsApplicationTests {

    @Autowired
    @SuppressWarnings("all")
    OrderMapper orderMapper;

    @Autowired
    BuyServiceImpl buyService;

    @Autowired
    OrderAuditorServiceImpl orderAuditorService;

    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    ReturnGoodsServiceImpl returnGoodsService;

    @Autowired
    ReturnSaleServiceImpl returnSaleService;

    @Autowired
    SaleServiceImpl saleService;

    ObjectMapper objectMapper = new ObjectMapper();

    Page page = null;
    BuyTo buyTo = null;
    ReturngoodsTo returngoodsTo = null;

    ReturnSaleTo returnSaleTo = null;

    SaleTo saleTo = null;


    @BeforeEach
    public void before() {
        page = new Page<>();
        page.setSize(2);
        page.setPages(0);
        buyTo = new BuyTo();
        saleTo = new SaleTo();
    }

    @Test
    void orderMapperTest() {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.setSql("UPDATE `order_` SET `order_price_sum`=500 WHERE `order_id`=27");
        orderMapper.update(null, updateWrapper);
    }

    @Test
    void buyServiceTest() throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(buyService.getBuyPage(page, buyTo)));
    }

    @Test
    void orderAuditorServiceTest() throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(orderAuditorService.list()));
    }

    @Test
    void orderServiceTest() throws JsonProcessingException {
        Order order = new Order();
        order.setOrderCode("10005");
        order = orderService.insertOrder(order);
        System.out.println(order.getOrderId());
    }

    @Test
    void returngoodssServiceTest() throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(returnGoodsService.getReturnGoodsPage(page, returngoodsTo)));
    }

    @Test
    void returnSaleServiceTest() throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(returnSaleService.getSalePage(page, returnSaleTo)));
    }

    @Test
    void saleServiceTo() throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(saleService.getSalePage(page, saleTo)));
    }
}
