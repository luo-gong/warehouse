package lg.cn.whmwms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.whmwms.entity.Inwarehouse;
import lg.cn.whmwms.entity.InwarehouseType;
import lg.cn.whmwms.mapper.InwarehouseMapper;
import lg.cn.whmwms.service.InwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

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
public class InwarehouseServiceImpl extends ServiceImpl<InwarehouseMapper, Inwarehouse> implements InwarehouseService {

    public IPage getPage(Map<String, Object> map, Page<Inwarehouse> page) {
        QueryWrapper queryWrapper = new QueryWrapper();
        page.setSize(2);
        queryWrapper.eq("inwarehouse_isDelete", 0);
        if (null != map) {
            if (!StringUtils.isEmpty(map.get("inwarehouseTypeId"))) {
                queryWrapper.eq("inwarehouse_type_id", map.get("inwarehouseTypeId"));
            }
            if (!StringUtils.isEmpty(map.get("orderAuditorState"))) {
                queryWrapper.eq("order_auditor_state", map.get("orderAuditorState"));
            }
        }
        return this.page(page, queryWrapper);
    }

}
