package lg.cn.whmbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.whmbms.entity.Customer;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-02
 */
public interface CustomerService extends IService<Customer> {

    Customer getCutomerByCode(String customerCode);
}
