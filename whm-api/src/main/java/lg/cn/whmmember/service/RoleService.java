package lg.cn.whmmember.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lg.cn.whmmember.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public Integer addRole(Role role);

    public void delRole(Integer rid);

    public Role getRoleById(Integer rid) throws JsonProcessingException;

    public Integer updateRole(Role role);

    public List<Role> findAll();

    Page<Role> getRolesPage(Map<String, Object> map, Pageable pageable);

    void updateRoleIsDelete(Integer rid);
}
