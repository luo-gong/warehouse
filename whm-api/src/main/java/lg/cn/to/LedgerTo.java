package lg.cn.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class LedgerTo implements Serializable {
    private String productCode;//产品编号
    private String productName;
    private String productBatch;
    private Integer warehouseEndId;//仓库表id
}
