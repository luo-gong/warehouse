package lg.cn.whmsms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lg.cn.to.LedgerTo;
import lg.cn.whmsms.entity.Ledger;
import lg.cn.whmsms.mapper.LedgerMapper;
import lg.cn.whmsms.service.LedgerService;
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
public class LedgerServiceImpl extends ServiceImpl<LedgerMapper, Ledger> implements LedgerService {

    @Autowired
    @SuppressWarnings("all")
    LedgerMapper ledgerMapper;

    public IPage<Ledger> getLedgerPage(LedgerTo ledgerTo, Page<Ledger> page) {
        page.setSize(2);
        QueryWrapper<Ledger> queryWrapper = new QueryWrapper<>();
        if (null != ledgerTo) {
            if (!StringUtils.isEmpty(ledgerTo.getProductCode()))
                queryWrapper.like("product_code", ledgerTo.getProductCode());
            if (!StringUtils.isEmpty(ledgerTo.getProductBatch()))
                queryWrapper.like("product_batch", ledgerTo.getProductBatch());
            if (!StringUtils.isEmpty(ledgerTo.getProductName()))
                queryWrapper.like("product_name", ledgerTo.getProductName());
            if (!StringUtils.isEmpty(ledgerTo.getWarehouseEndId()))
                queryWrapper.eq("warehouse_end_id", ledgerTo.getWarehouseEndId());
        }
        return ledgerMapper.selectPage(page, queryWrapper);
    }


}
