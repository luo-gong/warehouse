package lg.cn.whmmember.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.cn.exception.UserException;
import lg.cn.vo.UserVo;
import lg.cn.whmmember.dao.MenuRepository;
import lg.cn.whmmember.dao.UserRepository;
import lg.cn.whmmember.entity.Role;
import lg.cn.whmmember.entity.User;
import lg.cn.whmmember.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserServiceImpl implements UserDetailsService, UserService {
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    @Qualifier("userRepository")
    UserRepository userRepository;

    @Autowired
    @Qualifier("menuRepository")
    MenuRepository menuRepository;


    /**
     * 加载用户认证
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<String> authorizations = new ArrayList<>();
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles = new ArrayList<>(user.getRoles());//获取用户的角色信息
        authorizations.addAll(roles.stream()
                .map(role -> role.getName())
                .collect(Collectors.toList()));//将角色添加到集合中

        roles.stream().forEach(role ->
                {
                    authorizations.addAll(menuRepository.findMenusByRoleId(role.getId())
                            .stream()
                            .map(menu -> menu.getPattern()).collect(Collectors.toList()));
                }
        );
        try {
            System.out.println(objectMapper.writeValueAsString(authorizations));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Collection<GrantedAuthority> grantedAuthorities
                = authorizations.stream()
                .map(authorization ->
                        new SimpleGrantedAuthority(authorization))
                .collect(Collectors.toList());


        user.setGrantedAuthorities(grantedAuthorities);
        return user;
    }

    /**
     * 根据用户名注册账号
     *
     * @param user
     * @return
     */
    @Override
    public Integer registerUserByUserName(User user) throws Exception {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new UserException("用户用户名重复自定义异常");
        }
        return userRepository.save(user) == null ? 0 : 1;
    }

    /**
     * 根据手机号注册账号
     *
     * @param user
     * @return
     */
    @Override
    public Integer registerUserByMobile(User user) throws Exception {
        if (userRepository.findUserByMobile(user.getMobile()) != null) {
            throw new UserException("用户手机号重复自定义异常");
        }
        return userRepository.save(user) == null ? 0 : 1;
    }

    /**
     * 根据邮箱注册账号
     *
     * @param user
     * @return
     */
    @Override
    public Integer registerUserByEmail(User user) throws Exception {
        if (userRepository.findUserByMobile(user.getMobile()) != null) {
            throw new UserException("用户邮箱重复自定义异常");
        }
        return userRepository.save(user) == null ? 0 : 1;
    }

    /**
     * 查询用户分页
     *
     * @param pageRequest
     * @param map
     * @return
     */
    @Override
    public Page<User> getPage(PageRequest pageRequest, Map<String, Object> map) {
        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                System.out.println(root.getModel());
                List<Predicate> list = new ArrayList();
                Join<User, Role> roles = root.join("roles", JoinType.LEFT);//多表连接，roles是 User中的属性
                list.add(criteriaBuilder.equal(root.get("isDelete"), 0));
                if (map.get("username") != null) {
                    Path<String> username = root.get("username");
                    list.add(criteriaBuilder.like(username, "%" + map.get("username") + "%"));//将查询的条件添加到list中
                }
                if (map.get("userId") != null) {
                    Path<Integer> id = root.get("id");
                    list.add(criteriaBuilder.equal(id, map.get("userId")));//将查询的条件添加到list中
                }
                if (map.get("rid") != null) {
                    list.add(criteriaBuilder.equal(roles.get("id"), map.get("rid")));//将查询的条件添加到list中
                }
                Predicate[] predicates = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(predicates));
            }
        };
        Page<User> users = userRepository.findAll(specification, pageRequest);
        return users;
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
        log.info("UserServiceImpl>>>findUserById>>>return" + userRepository.findById(id).get());
        return userRepository.findById(id).get();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Transactional
    public Integer deleteUserById(Integer id) {
        userRepository.deleteUserRoleById(id);
        return userRepository.updateUserDeleteByid(id);
    }

    /**
     * 新增用户
     *
     * @return
     */
    @Transactional
    public void addUser(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        role.setId(userVo.getRid());
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }


    /**
     * 用户修改
     *
     * @param userVo
     */
    @Transactional
    public void userUpdate(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        userRepository.updateUser(user);
        if (userRepository.updateUserRoleByid(userVo) < 1) {
            userRepository.insertUserRoleByid(userVo);
        }
    }


}
