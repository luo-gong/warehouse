package lg.cn.whmmember.dao;

import lg.cn.whmmember.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {


    @Query(value = "SELECT m.* FROM `menu` m,`menu_role` m_r,`role` r WHERE  m.`id`=m_r.`mid` AND r.id=m_r.`rid` AND r.`id`=:roleId", nativeQuery = true)
    public List<Menu> findMenusByRoleId(Integer roleId);


    @Modifying
    @Query(value = "UPDATE `menu` SET `pattern`=:#{#menu.pattern},`name`=:#{#menu.name} WHERE id=:#{#menu.id}", nativeQuery = true)
    public Integer updateMenu(Menu menu);
}
