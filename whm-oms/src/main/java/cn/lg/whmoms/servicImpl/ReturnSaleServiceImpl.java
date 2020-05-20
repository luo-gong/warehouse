package cn.lg.whmoms.servicImpl;

import cn.lg.whmoms.mapper.ReturnSaleMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.ReturnSaleTo;
import lg.cn.whmoms.entity.ReturnSale;
import lg.cn.whmoms.entity.Sale;
import lg.cn.whmoms.service.ReturnSaleService;
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
public class ReturnSaleServiceImpl extends ServiceImpl<ReturnSaleMapper, ReturnSale> implements ReturnSaleService {

    @Autowired
    @SuppressWarnings("all")
    ReturnSaleMapper returnSaleMapper;

    @Override
    public IPage<ReturnSale> getSalePage(Page<ReturnSale> page, ReturnSaleTo returnSaleTo) {
        page.setSize(2);
        QueryWrapper<ReturnSale> queryWrapper = null;
        if (null != returnSaleTo) {
            queryWrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(returnSaleTo.getSaleCode()))
                queryWrapper.like("sale_code", returnSaleTo.getSaleCode());
            if (!StringUtils.isEmpty(returnSaleTo.getReturnSaleCode()))
                queryWrapper.like("return_sale_code", returnSaleTo.getReturnSaleCode());
            if (!StringUtils.isEmpty(returnSaleTo.getProductName()))
                queryWrapper.like("product_name", returnSaleTo.getProductName());
            if (!StringUtils.isEmpty(returnSaleTo.getOrderAuditorId()))
                queryWrapper.eq("order_auditor_id", returnSaleTo.getOrderAuditorId());
        }
        return returnSaleMapper.selectPage(page, queryWrapper);
    }
}
