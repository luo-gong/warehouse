package cn.lg.whmoms.servicImpl;

import cn.lg.whmoms.mapper.ReturnGoodsMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.to.ReturngoodsTo;
import lg.cn.whmoms.entity.Buy;
import lg.cn.whmoms.entity.ReturnGoods;
import lg.cn.whmoms.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-11
 */
@Service
@Component
public class ReturnGoodsServiceImpl extends ServiceImpl<ReturnGoodsMapper, ReturnGoods> implements ReturnGoodsService {

    @Autowired
    @SuppressWarnings("all")
    ReturnGoodsMapper returnGoodsMapper;

    @Override
    public IPage<ReturnGoods> getReturnGoodsPage(Page<ReturnGoods> page, ReturngoodsTo returngoodsTo) {
        page.setSize(2);
        QueryWrapper<ReturnGoods> queryWrapper = null;
        if (null != returngoodsTo) {
            queryWrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(returngoodsTo.getBuyCode()))
                queryWrapper.like("buy_code", returngoodsTo.getBuyCode());
            if (!StringUtils.isEmpty(returngoodsTo.getReturnGoodsCode()))
                queryWrapper.like("product_code", returngoodsTo.getReturnGoodsCode());
            if (!StringUtils.isEmpty(returngoodsTo.getProductName()))
                queryWrapper.like("product_name", returngoodsTo.getProductName());
            if (!StringUtils.isEmpty(returngoodsTo.getOrderAuditorId()))
                queryWrapper.eq("order_auditor_id", returngoodsTo.getOrderAuditorId());
        }
        return returnGoodsMapper.selectPage(page, queryWrapper);
    }
}
