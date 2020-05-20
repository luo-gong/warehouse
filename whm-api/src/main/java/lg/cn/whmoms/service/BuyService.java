package lg.cn.whmoms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.to.BuyTo;
import lg.cn.whmoms.entity.Buy;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface BuyService extends IService<Buy> {

    IPage<Buy> getBuyPage(Page<Buy> page, BuyTo buyTo);
}
