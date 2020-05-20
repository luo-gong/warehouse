package lg.cn.whmbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.whmbms.entity.Product;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-02
 */
public interface ProductService extends IService<Product> {

    public List<Product> getProductByProduct(Product product);
}
