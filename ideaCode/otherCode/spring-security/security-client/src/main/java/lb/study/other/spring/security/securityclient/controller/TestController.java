package lb.study.other.spring.security.securityclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/6/20 11:30
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request){
        System.out.println("----------------header----------------");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        System.out.println("----------------header----------------");
        return "test";
    }
}
