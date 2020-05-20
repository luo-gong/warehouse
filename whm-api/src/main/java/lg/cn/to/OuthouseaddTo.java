package lg.cn.to;

import lg.cn.whmoms.entity.Order;
import lg.cn.whmwms.entity.Outwarehouse;
import lombok.Data;

import java.util.List;

@Data
public class OuthouseaddTo extends Outwarehouse {
    private List<Order> orders;

}
