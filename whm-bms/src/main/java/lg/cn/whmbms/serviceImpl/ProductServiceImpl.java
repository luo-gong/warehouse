package lg.cn.whmbms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lg.cn.whmbms.entity.Product;
import lg.cn.whmbms.mapper.ProductMapper;
import lg.cn.whmbms.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-02
 */
@Service
@Component
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    @SuppressWarnings("all")
    ProductMapper productMapper;

    public List<Product> getProductByProduct(Product product) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(product.getProductCode()))
            queryWrapper.like("product_code", product.getProductCode());
        if (!StringUtils.isEmpty(product.getProductName()))
            queryWrapper.like("product_name", product.getProductName());
        return productMapper.selectList(queryWrapper);
    }
}
