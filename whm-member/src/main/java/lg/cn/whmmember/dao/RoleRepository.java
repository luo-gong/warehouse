package lg.cn.whmmember.dao;

import lg.cn.vo.RoleVo;
import lg.cn.whmmember.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    @Query(value = "SELECT r.* FROM `role` r,`user` u,`user_role` u_r WHERE r.`id`=u_r.`rid`  AND  u.`id`=u_r.`uid` AND u.`id`=:userId", nativeQuery = true)
    public List<Role> findRolesByUserId(Integer userId);

    @Modifying
    @Query(value = "UPDATE `role` r SET r.`enabled`=0 WHERE r.id=:id", nativeQuery = true)
    public Integer updateRoleEnableById(Integer id);

    @Modifying
    @Query(value = "UPDATE `role` r SET r.`remarks`=:#{#role.remarks}," +
            "r.name=:#{#role.name},r.nameZh=:#{#role.nameZh} WHERE r.id=:#{#role.id}", nativeQuery = true)
    public Integer updateRole(Role role);

    @Modifying
    @Query(value = "UPDATE `role` r SET r.`isDelete`=1 WHERE r.id=:rid", nativeQuery = true)
    void updateRoleIsDelete(Integer rid);

    /**
     * 删除中间表数据
     *
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "DELETE FROM `menu_role` WHERE `rid`=:id", nativeQuery = true)
    public Integer deleteRoleMenuById(Integer id);

    /**
     * 增加中间表数据
     *
     * @return
     */
    @Modifying
    @Query(value = "INSERT INTO `menu_role`(`mid`,`rid`,`enabled`) VALUES(:#{#roleVo.mid},:#{#roleVo.id},1)", nativeQuery = true)
    public Integer saveRoleMenuById(RoleVo roleVo);


    @Modifying
    @Query(value = "DELETE FROM `menu_role` WHERE  `rid`=:#{#roleVo.id}", nativeQuery = true)
    Integer deleteRoleMenu(RoleVo roleVo);
}
