package lg.cn.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class BuyTo implements Serializable {
    private String productName;
    private String productCode;
    private String buyCode;
    private Integer orderAuditorId;//订单审核状态


}
