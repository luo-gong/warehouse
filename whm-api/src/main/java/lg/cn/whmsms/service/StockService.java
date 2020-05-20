package lg.cn.whmsms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.to.StockTo;
import lg.cn.whmsms.entity.Stock;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface StockService extends IService<Stock> {

    IPage<Stock> getStockPage(StockTo stockTo, Page<Stock> page);
}
