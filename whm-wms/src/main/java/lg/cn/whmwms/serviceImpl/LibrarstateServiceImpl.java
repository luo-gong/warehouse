package lg.cn.whmwms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.whmwms.entity.Librarstate;
import lg.cn.whmwms.mapper.LibrarstateMapper;
import lg.cn.whmwms.service.LibrarstateService;
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
public class LibrarstateServiceImpl extends ServiceImpl<LibrarstateMapper, Librarstate> implements LibrarstateService {

}
