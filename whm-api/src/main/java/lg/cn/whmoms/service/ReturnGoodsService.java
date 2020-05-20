package lg.cn.whmoms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.to.ReturngoodsTo;
import lg.cn.whmoms.entity.ReturnGoods;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-11
 */
public interface ReturnGoodsService extends IService<ReturnGoods> {

    IPage<ReturnGoods> getReturnGoodsPage(Page<ReturnGoods> page, ReturngoodsTo returngoodsTo);
}
