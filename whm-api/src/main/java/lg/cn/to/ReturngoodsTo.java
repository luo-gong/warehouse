package lg.cn.to;


import lombok.Data;

import java.io.Serializable;

@Data
public class ReturngoodsTo implements Serializable {

    private String productName;//产品名称
    private String buyCode;//采购单编号
    private String returnGoodsCode;//退货单号
    private Integer orderAuditorId;//订单审核状态


}
