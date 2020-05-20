package cn.lg.whmoms.servicImpl;

import cn.lg.whmoms.mapper.OrderAuditorMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.whmoms.entity.OrderAuditor;
import lg.cn.whmoms.service.OrderAuditorService;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-11
 */
@Service
@Component
public class OrderAuditorServiceImpl extends ServiceImpl<OrderAuditorMapper, OrderAuditor> implements OrderAuditorService {

}
