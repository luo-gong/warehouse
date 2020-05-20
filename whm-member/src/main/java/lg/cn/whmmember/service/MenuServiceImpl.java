package lg.cn.whmmember.service;

import com.alibaba.dubbo.config.annotation.Service;
import lg.cn.whmmember.dao.MenuRepository;
import lg.cn.whmmember.entity.Menu;
import lg.cn.whmmember.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    /**
     * 查询权限分页
     *
     * @param pageable
     * @return
     */
    public Page<Menu> getMenusPage(Map<String, Object> map, Pageable pageable) {
        Specification<Menu> specification = new Specification<Menu>() {
            @Override
            public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (null != map.get("pattern"))
                    list.add(criteriaBuilder.like(root.get("pattern"),
                            "%" + map.get("pattern") + "%"));
                if (null != map.get("name"))
                    list.add(criteriaBuilder.like(root.get("name"), "%" + map.get("name") + "%"));
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return menuRepository.findAll(specification, pageable);
    }

    /**
     * 根据id查看权限
     *
     * @param id
     * @return
     */
    public Menu findById(Integer id) {
        return menuRepository.findById(id).get();
    }

    public List<Menu> getMenuAll() {
        return menuRepository.findAll();
    }

    @Override
    public Integer addMenu(Menu menu) {
        return menuRepository.save(menu) == null ? 0 : 1;
    }

    @Override
    public void delMenu(Integer mId) {
        menuRepository.deleteById(mId);
    }

    @Transactional
    @Override
    public Integer updateMenu(Menu menu) {
        return menuRepository.updateMenu(menu);
    }
}
