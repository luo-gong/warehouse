package cn.lg.whmoms.servicImpl;

import cn.lg.whmoms.mapper.SaleMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.SaleTo;
import lg.cn.whmoms.entity.Sale;
import lg.cn.whmoms.service.SaleService;
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
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements SaleService {

    @Autowired
    @SuppressWarnings("all")
    SaleMapper saleMapper;

    @Override
    public IPage<Sale> getSalePage(Page<Sale> page, SaleTo saleTo) {
        page.setSize(2);
        QueryWrapper<Sale> queryWrapper = null;
        if (null != saleTo) {
            queryWrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(saleTo.getSaleCode()))
                queryWrapper.like("sale_code", saleTo.getSaleCode());
            if (!StringUtils.isEmpty(saleTo.getProductCode()))
                queryWrapper.like("product_code", saleTo.getProductCode());
            if (!StringUtils.isEmpty(saleTo.getProductName()))
                queryWrapper.like("product_name", saleTo.getProductName());
            if (!StringUtils.isEmpty(saleTo.getOrderAuditorId()))
                queryWrapper.eq("order_auditor_id", saleTo.getOrderAuditorId());
        }
        return saleMapper.selectPage(page, queryWrapper);

    }
}
