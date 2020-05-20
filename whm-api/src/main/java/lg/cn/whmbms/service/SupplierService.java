package lg.cn.whmbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.whmbms.entity.Supplier;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-02
 */
public interface SupplierService extends IService<Supplier> {

    Object getSupplierByCode(String supplierCode);
}
