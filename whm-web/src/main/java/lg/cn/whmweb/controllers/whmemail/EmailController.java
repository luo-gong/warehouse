package lg.cn.whmweb.controllers.whmemail;

import lg.cn.to.CommonResult;
import lg.cn.validation.EmailRegister;
import lg.cn.whmemail.service.JavaMailSendService;
import lg.cn.whmmember.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
@Controller
public class EmailController {

    @Resource
    JavaMailSendService javaMailSendService;

    @Resource
    RedisTemplate redisTemplate;

    */
/*   *//*
 */
/**
 * 跳转根据邮箱登录页面
 *
 * @return 邮箱
 * <p>
 * 发送邮箱验证码
 * @param user
 * @return 邮箱
 * <p>
 * 发送邮箱验证码
 * @param user
 * @return 邮箱
 * <p>
 * 发送邮箱验证码
 * @param user
 * @return 邮箱
 * <p>
 * 发送邮箱验证码
 * @param user
 * @return
 *//*
 */
/*
    @GetMapping("registByEmail")
    public String registByEmailHtml() {
        return "market/registUserByEmail";
    }

    *//*
 */
/**
 * 邮箱
 *//*
 */
/*
    @PostMapping("registByEmail")
    @ResponseBody
    public CommonResult registByEmail(@Validated({EmailRegister.class}) User user,
                                      String emailCode,
                                      BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new CommonResult().failed();
        }
        if (redisTemplate.opsForValue().get("emailCode").equals(emailCode)) {
            if (userService.registerUserByEmail(user) > 0) {
                return new CommonResult().success("");
            }
        } else {
            return new CommonResult().failed();
        }
        return new CommonResult().failed();
    }*//*


 */
/* *//*
 */
/**
 * 发送邮箱验证码
 *
 * @param user
 * @return
 *//*
 */
/*
    @GetMapping(value = "emailCode")
    @ResponseBody
    public Object emailCode(String user) {
        Integer email = new Random().nextInt(9000) + 999;
        rabbitTemplate.convertAndSend("maket.email.code", email);
        redisTemplate.opsForValue().set("emailCode", email.toString(), 60, TimeUnit.SECONDS);
        System.out.println("email" + email);
        return new Response("result", "success");
    }*//*

}
*/
