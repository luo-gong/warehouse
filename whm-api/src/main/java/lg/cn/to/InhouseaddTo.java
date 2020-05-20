package lg.cn.to;

import lg.cn.whmoms.entity.Order;
import lg.cn.whmwms.entity.Inwarehouse;
import lombok.Data;

import java.util.List;

@Data
public class InhouseaddTo extends Inwarehouse {
    private List<Order> orders;
}
