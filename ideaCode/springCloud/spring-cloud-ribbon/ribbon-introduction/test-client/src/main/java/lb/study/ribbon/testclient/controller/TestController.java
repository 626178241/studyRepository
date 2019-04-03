package lb.study.ribbon.testclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/1/8 14:00
 */
@RestController
@RequestMapping("/lb/study/ribbon/introduction")
public class TestController {

    @RequestMapping("/test")
    public String test(Integer a, Integer b, HttpServletRequest request){

        return "端口："+request.getServerPort()+" ,结果："+(a+b);
    }
}
