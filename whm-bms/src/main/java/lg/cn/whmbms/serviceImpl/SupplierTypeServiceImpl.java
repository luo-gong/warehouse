package lg.cn.whmbms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import lg.cn.whmbms.entity.SupplierType;
import lg.cn.whmbms.mapper.SupplierTypeMapper;
import lg.cn.whmbms.service.SupplierTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SupplierTypeServiceImpl extends ServiceImpl<SupplierTypeMapper, SupplierType> implements SupplierTypeService {

}
