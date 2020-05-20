package lg.cn.whmwms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.to.OutwarehouseUpdateTo;
import lg.cn.whmwms.entity.Outwarehouse;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface OutwarehouseService extends IService<Outwarehouse> {

    List<Outwarehouse> getOutwarehouseByCode(String outwarehouseCode);

    IPage<Outwarehouse> getPage(Map<String, Object> map, Page<Outwarehouse> page);


}
