package lb.study.springcloudzuul.clienta.controller;

import com.netflix.loadbalancer.RoundRobinRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/4/15 14:48
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @RequestMapping("/getStudent")
    public String getStudent(HttpServletRequest request){
        int serverPort = request.getServerPort();
        log.error(String.valueOf(serverPort));
        return "这是一个学生"+String.valueOf(serverPort);
    }
}
