package lg.cn.whmbms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import lg.cn.whmbms.entity.StorehouseType;
import lg.cn.whmbms.mapper.StorehouseTypeMapper;
import lg.cn.whmbms.service.StorehouseTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-02
 */
@Service
@Component
public class StorehouseTypeServiceImpl extends ServiceImpl<StorehouseTypeMapper, StorehouseType> implements StorehouseTypeService {

}
