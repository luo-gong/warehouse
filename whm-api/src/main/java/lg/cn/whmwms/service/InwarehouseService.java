package lg.cn.whmwms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import lg.cn.whmwms.entity.Inwarehouse;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
public interface InwarehouseService extends IService<Inwarehouse> {

    public IPage getPage(Map<String, Object> map, Page<Inwarehouse> page);
}
