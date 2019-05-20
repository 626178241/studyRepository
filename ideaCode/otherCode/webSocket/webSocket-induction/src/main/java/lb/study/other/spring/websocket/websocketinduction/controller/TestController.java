package lb.study.other.spring.websocket.websocketinduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/20 14:41
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String toIndex(){

        return "index";

    }

}
