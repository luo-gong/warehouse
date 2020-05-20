package lg.cn.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockTo implements Serializable {
    private String productCode;//参评编号
    private String productName;
    private String productBatch;
    private Integer warehouseId;//仓库表id
}
