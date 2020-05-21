package lg.cn.whmwms.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.whmwms.entity.Bill;
import lg.cn.whmwms.mapper.BillMapper;
import lg.cn.whmwms.service.BillService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

}
