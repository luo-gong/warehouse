package lg.cn.whmweb.controllers.wms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoveController {

    @GetMapping("movehouse")
    public String movehouseHtml() {


        return "movehouse";
    }

}
