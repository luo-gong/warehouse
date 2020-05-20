package lg.cn.to;

import lg.cn.whmbms.entity.Product;
import lg.cn.whmbms.entity.Storehouse;
import lombok.Data;
import org.apache.catalina.Store;

import java.util.List;

/**
 * 新增出库
 */
@Data
public class ProductStorehouseTo extends Product {

    private List<StorehouseTo> storehouselist;


}
