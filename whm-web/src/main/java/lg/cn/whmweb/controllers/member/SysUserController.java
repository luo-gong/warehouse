package lg.cn.whmweb.controllers.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import lg.cn.to.CommonResult;
import lg.cn.validation.UsernameRegister;
import lg.cn.vo.UserVo;
import lg.cn.whmmember.entity.User;
import lg.cn.whmmember.service.RoleService;
import lg.cn.whmmember.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class SysUserController {

    ObjectMapper objectMapper = new ObjectMapper();
    /*@Autowired
    RedisTemplate redisTemplate;
*/
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    /**
     * 用户管理数据展示
     *
     * @param username
     * @param userId
     * @param roleId
     * @param page
     * @param modelMap
     * @return
     */
    @GetMapping("userHtml")
    public String userHtml(@RequestParam(required = false) String username,
                           @RequestParam(required = false) String userId,
                           @RequestParam(required = false) String roleId,
                           @RequestParam(required = false) Integer page,
                           ModelMap modelMap) {
        PageRequest pageRequest = PageRequest.of(page == null ? 0 : page, 2);
        Map map = new HashMap();
        if (!StringUtils.isEmpty(username))
            map.put("username", username);
        if (!StringUtils.isEmpty(userId))
            map.put("userId", userId);
        if (!StringUtils.isEmpty(roleId))
            map.put("rid", roleId);
        Page<User> pageImpl = userService.getPage(pageRequest, map);
        List<User> users = pageImpl.getContent();
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("username", username);
        modelMap.addAttribute("userId", userId);
        modelMap.addAttribute("roleId", roleId);
        modelMap.addAttribute("pages",
                new String[pageImpl.getTotalPages()]);
        modelMap.addAttribute("roles", roleService.findAll());
        return "admin/user/user";
    }


    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("findUserById")
    @ResponseBody
    public Object findUserById(@RequestParam Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("deleteUserById")
    @ResponseBody
    public Object deleteUserById(@RequestParam Integer id) {
        return userService.deleteUserById(id);
    }

    /**
     * 跳转到用户新增页面
     *
     * @param modelMap
     * @return
     */
    @GetMapping("useraddHtml")
    public String useraddHtml(ModelMap modelMap) {
        modelMap.addAttribute("roles", roleService.findAll());
        return "admin/user/adduser";
    }

    /**
     * 用户新增
     *
     * @return
     */
    @PostMapping("useradd")
    @Transactional
    public String useradd(UserVo userVo) {
        userVo.setDelete(false);
        userVo.setEnabled(true);
        userVo.setLocked(false);
        userService.addUser(userVo);
        return "redirect:/user/userHtml";
    }

    /**
     * 跳转到用户修改页面
     *
     * @param modelMap
     * @return
     */
    @GetMapping("userUpdateHtml")
    public String userUpdateHtml(ModelMap modelMap, Integer id) {
        modelMap.addAttribute("roles", roleService.findAll());
        modelMap.addAttribute("user", userService.findUserById(id));
        return "admin/user/userUpdate";
    }

    /**
     * 用户修改
     *
     * @return
     */
    @PostMapping("userUpdate")
    public String userUpdate(UserVo userVo) {
        userService.userUpdate(userVo);
        return "redirect:/user/userHtml";
    }

    /**
     * 删除
     *
     * @return
     */
    @GetMapping("userDelete")
    public String userDelete(Integer userId) {
        userService.deleteUserById(userId);
        return "redirect:/user/userHtml";
    }


    /**
     * @param password
     * @param username
     * @param request
     * @return
     */
    @PostMapping(value = "login", produces = {"text/html;charset=utf-8"})
    public String loginText(@RequestParam("password") String password,
                            @RequestParam("username") String username, HttpServletRequest request) {
        return "forward:/login";
    }


    /**
     * 跳转根据用户名注册页面
     *
     * @return
     */
    @GetMapping("registUserByUsername")
    public String registUserByUsernameHtml() {
        return "market/registUserByUsername";
    }

    /**
     * 跳转根据邮箱注册页面
     *
     * @return
     */
    @GetMapping("registByEmail")
    public String registByEmailHtml() {
        return "market/registUserByEmail";
    }

    /**
     * 用户名注册
     */
    @PostMapping("registByUsername")
    @ResponseBody
    public Object registByUsername(@Validated(UsernameRegister.class) User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new CommonResult().validateFailed("faile");
        }
        if (userService.registerUserByUserName(user) > 0) {
            return new CommonResult().forbidden("success");
        }
        return new CommonResult().failed();
    }

    /*   *//**
     * 邮箱注册
     *//*
    @PostMapping("registByEmail")
    @ResponseBody
    public Object registByEmail(@Validated({EmailRegister.class}) User user,
                                String emailCode,
                                BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new CommonResult().success("result");
        }
        if (redisTemplate.opsForValue().get("emailCode").equals(emailCode)) {
            if (userService.registerUserByEmail(user) > 0) {
                return new CommonResult().success("result");
            }
        } else {
            return new CommonResult().forbidden("验证码错误");
        }

        return new CommonResult().SUCCESS("result");
    }*/

    /* *//**
     * 发送邮箱验证码
     *
     * @param user
     * @return
     *//*
    @GetMapping(value = "emailCode")
    @ResponseBody
    public Object emailCode(String user) {
        Integer email = new Random().nextInt(9000) + 999;
        rabbitTemplate.convertAndSend("maket.email.code", email);
        redisTemplate.opsForValue().set("emailCode", email.toString(), 60, TimeUnit.SECONDS);
        System.out.println("email" + email);
        return new Response("result", "success");
    }*/


}
