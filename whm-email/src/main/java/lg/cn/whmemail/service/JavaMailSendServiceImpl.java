package lg.cn.whmemail.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

//@EnableAsync //开启异步注解支持
@Component
@Service
public class JavaMailSendServiceImpl implements JavaMailSendService {

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 简单邮件发送
     *
     * @param user
     * @param message
     */
//    @Async
    @RabbitListener(queues = "${amqp.queue.name}")
    public void sendSimpleMail(String user, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("2813728976@qq.com");
        simpleMailMessage.setSubject("邮箱注册验证码");
        simpleMailMessage.setText("验证码：" + message);
        simpleMailMessage.setTo(user);
        javaMailSender.send(simpleMailMessage);
    }
}
