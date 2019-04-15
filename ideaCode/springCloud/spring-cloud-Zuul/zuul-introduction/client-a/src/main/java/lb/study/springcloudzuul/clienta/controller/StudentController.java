package lb.study.springcloudzuul.clienta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/4/15 14:48
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/getStudent")
    public String getStudent(){
        return "这是一个学生";
    }
}
