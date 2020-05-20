package lg.cn.to;

import lg.cn.whmoms.entity.Order;
import lg.cn.whmwms.entity.Inwarehouse;
import lombok.Data;

@Data
public class InwarehouseUpdateTo extends Inwarehouse {
    private Order order;
}
