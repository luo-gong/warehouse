package lg.cn.whmoms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.whmoms.entity.Order;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface OrderService extends IService<Order> {

    Order insertOrder(Order order);

    boolean updateOrderPriceSumByOrdercode(Order order);
}
