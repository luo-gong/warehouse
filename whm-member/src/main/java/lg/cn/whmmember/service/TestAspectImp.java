package lg.cn.whmmember.service;

import com.alibaba.dubbo.config.annotation.Service;
import lg.cn.aspect.pointcut.MyAnnotation;
import org.springframework.stereotype.Component;

@Component
public class TestAspectImp implements TestAsPect {

    @MyAnnotation(methoname = "testMethod")
    public Object testMethod(String name) {
        System.out.println("testMethod" + name);
        return "你好" + name;
    }
}
