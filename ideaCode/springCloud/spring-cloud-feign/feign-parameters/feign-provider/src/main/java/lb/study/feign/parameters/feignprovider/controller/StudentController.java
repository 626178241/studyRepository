package lb.study.feign.parameters.feignprovider.controller;

import lb.study.feign.parameters.feignprovider.entity.Student;
import lb.study.feign.parameters.feignprovider.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/27 16:50
 */
@RestController
@RequestMapping("/lb/feign/provider/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * @description 服务消费者接口
     * @param stu
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2018/12/27 17:25
     */
    @GetMapping("/addStudent")
    public String addStudent(Student stu){

        return studentService.addStudent(stu);
    }

    /**
     * @description 服务消费者接口
     * @param stu
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2018/12/27 17:25
     */
    @PostMapping("/updateStudent")
    public String updateStudent(@RequestBody Student stu){

        return studentService.updateStudent(stu);
    }
}
