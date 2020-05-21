package lg.cn.whmwms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.whmwms.entity.InwarehouseType;
import lg.cn.whmwms.mapper.InwarehouseTypeMapper;
import lg.cn.whmwms.service.InwarehouseTypeService;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
@Component
@Service
public class InwarehouseTypeServiceImpl extends ServiceImpl<InwarehouseTypeMapper, InwarehouseType> implements InwarehouseTypeService {

}
