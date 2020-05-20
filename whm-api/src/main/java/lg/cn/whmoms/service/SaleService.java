package lg.cn.whmoms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.to.SaleTo;
import lg.cn.whmoms.entity.Sale;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface SaleService extends IService<Sale> {

    IPage<Sale> getSalePage(Page<Sale> page, SaleTo saleTo);
}
