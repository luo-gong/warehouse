package lg.cn.whmbms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lg.cn.whmbms.entity.Supplier;
import lg.cn.whmbms.mapper.SupplierMapper;
import lg.cn.whmbms.service.SupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    @Autowired
    @SuppressWarnings("all")
    SupplierMapper supplierMapper;

    @Override
    public Object getSupplierByCode(String supplierCode) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("supplier_code", supplierCode);
        return supplierMapper.selectOne(queryWrapper);
    }
}
