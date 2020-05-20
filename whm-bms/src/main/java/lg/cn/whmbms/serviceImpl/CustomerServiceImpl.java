package lg.cn.whmbms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lg.cn.whmbms.entity.Customer;
import lg.cn.whmbms.mapper.CustomerMapper;
import lg.cn.whmbms.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    @SuppressWarnings("all")
    CustomerMapper customerMapper;

    @Override
    public Customer getCutomerByCode(String customerCode) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("customer_code", customerCode);
        return customerMapper.selectOne(queryWrapper);
    }
}
