package lg.cn.whmmember.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.cn.vo.RoleVo;
import lg.cn.whmmember.dao.RoleRepository;
import lg.cn.whmmember.entity.Menu;
import lg.cn.whmmember.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleRepository roleRepository;


    public Page<Role> getRolesPage(Map<String, Object> map, Pageable pageable) {
        Specification<Role> specification = new Specification<Role>() {
            @Override
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("isDelete"), 0));
                if (null != map.get("nameZh")) {
                    Path<String> nameZh = root.get("nameZh");
                    predicates.add(criteriaBuilder.like(nameZh, "%" + map.get("nameZh") + "%"));
                }
                if (null != map.get("remarks")) {
                    Path<String> remarks = root.get("remarks");
                    predicates.add(criteriaBuilder.like(remarks, "%" + map.get("remarks") + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return roleRepository.findAll(specification, pageable);
    }

    /**
     * 修改role isDelete
     *
     * @param rid
     */
    @Transactional
    public void updateRoleIsDelete(Integer rid) {
        roleRepository.deleteRoleMenuById(rid);
        roleRepository.updateRoleIsDelete(rid);
    }


    //    查询所有角色
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @Transactional
    public Integer addRole(Role role) {
        List<Menu> menus = new ArrayList<>();
        role.setMenus(role.getMenus()
                .stream()
                .filter(menu -> menu.getId() != null)
                .collect(Collectors.toList()));
        return roleRepository.save(role) == null ? 0 : 1;
    }

    /**
     * 删除角色
     *
     * @param rid
     */
    @Transactional
    public void delRole(Integer rid) {
        Integer count = roleRepository.updateRoleEnableById(rid);
    }

    /**
     * 根据角色id查询角色
     *
     * @param rid
     * @return
     */
    @Transactional
    public Role getRoleById(Integer rid) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Role role = roleRepository.getOne(rid);
        System.out.println(objectMapper.writeValueAsString(role.getMenus()));
        return role;
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @Transactional
    public Integer updateRole(Role role) {
        RoleVo roleVo = new RoleVo();
        BeanUtil.copyProperties(role, roleVo, CopyOptions.create()
                .setIgnoreNullValue(true)
                .setIgnoreError(true));
        roleRepository.deleteRoleMenu(roleVo);
        role.getMenus().forEach(menu -> {
            if (null != menu) {
                roleVo.setMid(menu.getId());
                roleRepository.saveRoleMenuById(roleVo);
            }
        });
        return roleRepository.updateRole(role);
    }

}
