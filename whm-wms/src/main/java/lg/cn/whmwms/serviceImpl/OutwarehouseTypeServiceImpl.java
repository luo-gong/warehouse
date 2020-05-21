package lg.cn.whmwms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.whmwms.entity.OutwarehouseType;
import lg.cn.whmwms.mapper.OutwarehouseTypeMapper;
import lg.cn.whmwms.service.OutwarehouseTypeService;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
@Service
@Component
public class OutwarehouseTypeServiceImpl extends ServiceImpl<OutwarehouseTypeMapper, OutwarehouseType> implements OutwarehouseTypeService {

}
