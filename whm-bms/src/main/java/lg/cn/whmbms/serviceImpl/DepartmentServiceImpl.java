package lg.cn.whmbms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import lg.cn.whmbms.entity.Department;
import lg.cn.whmbms.mapper.DepartmentMapper;
import lg.cn.whmbms.service.DepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
