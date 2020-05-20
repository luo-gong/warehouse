package cn.lg.whmoms.servicImpl;

import cn.lg.whmoms.mapper.OrderMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lg.cn.whmoms.entity.Order;
import lg.cn.whmoms.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
@Service
@Component
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    @SuppressWarnings("all")
    OrderMapper orderMapper;

    @Override
    public Order insertOrder(Order order) {
        orderMapper.insert(order);
        return order;
    }

    @Override
    public boolean updateOrderPriceSumByOrdercode(Order order) {
        return orderMapper.updateOrderNumberByOrdercode(order);
    }
}
