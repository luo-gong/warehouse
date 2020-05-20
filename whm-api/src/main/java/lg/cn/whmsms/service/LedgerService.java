package lg.cn.whmsms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.to.LedgerTo;
import lg.cn.whmsms.entity.Ledger;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface LedgerService extends IService<Ledger> {

    IPage<Ledger> getLedgerPage(LedgerTo ledgerTo, Page<Ledger> page);
}
