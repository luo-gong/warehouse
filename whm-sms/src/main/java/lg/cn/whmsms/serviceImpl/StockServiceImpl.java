package lg.cn.whmsms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.StockTo;
import lg.cn.whmsms.entity.Ledger;
import lg.cn.whmsms.entity.Stock;
import lg.cn.whmsms.mapper.StockMapper;
import lg.cn.whmsms.service.StockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
@Service
@Component
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Autowired
    @SuppressWarnings("all")
    StockMapper stockMapper;

    @Override
    public IPage<Stock> getStockPage(StockTo stockTo, Page<Stock> page) {
        page.setSize(2);
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        if (null != stockTo) {
            if (!StringUtils.isEmpty(stockTo.getProductCode()))
                queryWrapper.like("product_code", stockTo.getProductCode());
            if (!StringUtils.isEmpty(stockTo.getProductBatch()))
                queryWrapper.like("product_batch", stockTo.getProductBatch());
            if (!StringUtils.isEmpty(stockTo.getProductName()))
                queryWrapper.like("product_name", stockTo.getProductName());
            if (!StringUtils.isEmpty(stockTo.getWarehouseId()))
                queryWrapper.eq("warehouse_id", stockTo.getWarehouseId());
        }
        return stockMapper.selectPage(page, queryWrapper);
    }

    /**
     * 修改库存量
     */
    public Integer updateStockNumber(StockTo stockTo, Page<Stock> page) {

        return null;
    }

}
