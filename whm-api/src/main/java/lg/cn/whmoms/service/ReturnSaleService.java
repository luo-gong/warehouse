package lg.cn.whmoms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.to.ReturnSaleTo;
import lg.cn.whmoms.entity.ReturnSale;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface ReturnSaleService extends IService<ReturnSale> {

    IPage<ReturnSale> getSalePage(Page<ReturnSale> page, ReturnSaleTo returnSaleTo);
}
