package lg.cn.to;

import lg.cn.whmoms.entity.Order;
import lg.cn.whmwms.entity.Outwarehouse;
import lombok.Data;

import java.util.List;

/**
 * 编辑出库单时传递对象
 */
@Data
public class OutwarehouseUpdateTo extends Outwarehouse {
    private Order order;
}
