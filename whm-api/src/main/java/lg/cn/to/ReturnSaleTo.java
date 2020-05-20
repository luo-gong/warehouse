package lg.cn.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReturnSaleTo implements Serializable {
    private String productName;
    private String saleCode;
    private String returnSaleCode;
    private Integer orderAuditorId;

}
