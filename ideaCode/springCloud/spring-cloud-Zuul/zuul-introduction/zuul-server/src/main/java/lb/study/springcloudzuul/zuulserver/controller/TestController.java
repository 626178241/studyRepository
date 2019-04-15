package lb.study.springcloudzuul.zuulserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/4/15 17:06
 */
@RestController
public class TestController {

    @RequestMapping("/client/test")
    public String test(){
        return "test";
    }
}
