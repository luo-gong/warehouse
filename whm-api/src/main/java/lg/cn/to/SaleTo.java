package lg.cn.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class SaleTo implements Serializable {
    private String productName;
    private String productCode;
    private String saleCode;
    private Integer orderAuditorId;

}
