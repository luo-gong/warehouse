package cn.lg.whmoms.mapper;

import lg.cn.whmoms.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface OrderMapper extends BaseMapper<Order> {

    @Update("UPDATE `order_` SET `order_price_sum`=#{orderPriceSum} WHERE `order_code`=#{orderCode} ")
    public boolean updateOrderNumberByOrdercode(Order order);

}
