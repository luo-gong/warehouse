package lg.cn.whmweb.controllers.member;

import jdk.nashorn.internal.ir.annotations.Reference;
import lg.cn.whmmember.service.TestAsPect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspectController {

    @Autowired
    TestAsPect testAspect;


    @RequestMapping(value = "/aspect")
    public Object test() {
        return testAspect.testMethod("luogong");
    }

}
