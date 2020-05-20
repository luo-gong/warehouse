package lg.cn.whmmember.service;


import lg.cn.vo.UserVo;
import lg.cn.whmmember.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface UserService {

    public Integer registerUserByUserName(User user) throws Exception;

    public Integer registerUserByMobile(User user) throws Exception;

    public Integer registerUserByEmail(User user) throws Exception;


    public Page<User> getPage(PageRequest pageRequest, Map<String, Object> map);

    public User findUserById(Integer id);

    public Integer deleteUserById(Integer id);

    public void addUser(UserVo userVo);

   public void userUpdate(UserVo userVo);
}
