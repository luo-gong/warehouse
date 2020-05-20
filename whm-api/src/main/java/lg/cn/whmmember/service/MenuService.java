package lg.cn.whmmember.service;

import lg.cn.whmmember.entity.Menu;

import lg.cn.whmmember.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface MenuService {

    public List<Menu> getMenuAll();

    public Integer addMenu(Menu menu);

    public void delMenu(Integer mId);

    public Integer updateMenu(Menu menu);

    public Page<Menu> getMenusPage(Map<String, Object> map, Pageable pageable);

    Menu findById(Integer id);
}
