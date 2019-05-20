package lb.study.other.spring.websocket.websocketinduction.controller;

import lb.study.other.spring.websocket.websocketinduction.websocket.MyWebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/20 14:41
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("/index")
    public String toIndex(){

        return "index";

    }

    @RequestMapping("/test")
    public String test(String message) throws IOException {
        log.info("接口请求，反馈给用户信息========="+message);
        MyWebSocket.sendInfo(message);
        return "test";
    }

}
