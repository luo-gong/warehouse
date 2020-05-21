package lg.cn.whmwms.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lg.cn.to.OutwarehouseUpdateTo;
import lg.cn.whmwms.entity.Outwarehouse;
import lg.cn.whmwms.mapper.OutwarehouseMapper;
import lg.cn.whmwms.service.OutwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
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
public class OutwarehouseServiceImpl extends ServiceImpl<OutwarehouseMapper, Outwarehouse> implements OutwarehouseService {

    @Autowired
    @SuppressWarnings("all")
    OutwarehouseMapper outwarehouseMapper;


    @Override
    public List<Outwarehouse> getOutwarehouseByCode(String outwarehouseCode) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("outwarehouse_code", outwarehouseCode);
        return outwarehouseMapper.selectList(queryWrapper);
    }

    public IPage<Outwarehouse> getPage(Map<String, Object> map, Page<Outwarehouse> page) {
        QueryWrapper queryWrapper = new QueryWrapper();
        page.setSize(2);
        queryWrapper.eq("outwarehouse_isDelete", 0);
        if (null != map) {
            if (!StringUtils.isEmpty(map.get("outwarehouseTypeId"))) {
                queryWrapper.eq("outwarehouse_type_id", map.get("outwarehouseTypeId"));
            }
            if (!StringUtils.isEmpty(map.get("orderAuditorState"))) {
                queryWrapper.eq("order_auditor_state", map.get("orderAuditorState"));
            }
        }
        return this.page(page, queryWrapper);

    }
}
