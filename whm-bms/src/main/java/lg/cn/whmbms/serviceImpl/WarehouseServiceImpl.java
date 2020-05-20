package lg.cn.whmbms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import lg.cn.whmbms.entity.Warehouse;
import lg.cn.whmbms.mapper.WarehouseMapper;
import lg.cn.whmbms.service.WarehouseService;
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
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {

}
