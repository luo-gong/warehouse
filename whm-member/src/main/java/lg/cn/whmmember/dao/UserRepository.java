package lg.cn.whmmember.dao;

import lg.cn.vo.UserVo;
import lg.cn.whmmember.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query(value = "SELECT u.* FROM `user` u WHERE `username`=:username", nativeQuery = true)
    public User findUserByUsername(String username);

    @Query(value = "SELECT u.* FROM `user` u WHERE `mobile`=:mobile", nativeQuery = true)
    public User findUserByMobile(String mobile);


    /**
     * 删除中间表数据
     *
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "DELETE FROM `user_role` WHERE `uid`=:id", nativeQuery = true)
    public Integer deleteUserRoleById(Integer id);

    /**
     * 将用户置为已删除
     *
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "UPDATE `user` SET isDelete=1 WHERE id=:id", nativeQuery = true)
    public Integer updateUserDeleteByid(Integer id);

    @Modifying
    @Query(value = "UPDATE `user` u SET u.`username`=:#{#user.username}," +
            "u.`password`=:#{#user.password},u.`email`=:#{#user.email}," +
            "u.`mobile`=:#{#user.mobile}  where u.`id`=:#{#user.id}", nativeQuery = true)
    public Integer updateUser(User user);

    /**
     * 将修改中间表
     *
     * @return
     */
    @Modifying
    @Query(value = "UPDATE `user_role` SET `rid`=:#{#userVo.rid} WHERE uid=:#{#userVo.id}", nativeQuery = true)
    public Integer updateUserRoleByid(UserVo userVo);

    /**
     * 将新增中间表
     *
     * @return
     */
    @Modifying
    @Query(value = "INSERT INTO `user_role`(`uid`,`rid`) VALUES(:#{#userVo.id},:#{#userVo.rid})", nativeQuery = true)
    public Integer insertUserRoleByid(UserVo userVo);

}
