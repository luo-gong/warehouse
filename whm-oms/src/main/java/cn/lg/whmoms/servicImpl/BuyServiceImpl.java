package cn.lg.whmoms.servicImpl;

import cn.lg.whmoms.mapper.BuyMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.BuyTo;
import lg.cn.whmoms.entity.Buy;
import lg.cn.whmoms.service.BuyService;
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
@Component
@Service
public class BuyServiceImpl extends ServiceImpl<BuyMapper, Buy> implements BuyService {

    @Autowired
    @SuppressWarnings("all")
    BuyMapper buyMapper;

    public IPage<Buy> getBuyPage(Page<Buy> page, BuyTo buyTo) {
        page.setSize(2);
        QueryWrapper<Buy> queryWrapper = null;
        if (null != buyTo) {
            queryWrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(buyTo.getBuyCode()))
                queryWrapper.like("buy_code", buyTo.getBuyCode());
            if (!StringUtils.isEmpty(buyTo.getProductCode()))
                queryWrapper.like("product_code", buyTo.getProductCode());
            if (!StringUtils.isEmpty(buyTo.getProductName()))
                queryWrapper.like("product_name", buyTo.getProductName());
            if (!StringUtils.isEmpty(buyTo.getOrderAuditorId()))
                queryWrapper.eq("order_auditor_id", buyTo.getOrderAuditorId());
        }
        return buyMapper.selectPage(page, queryWrapper);
    }

}
