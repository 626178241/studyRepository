package lb.study.feign.parameters.feignconsumer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lb.study.feign.parameters.feignconsumer.entity.Student;
import lb.study.feign.parameters.feignconsumer.feignService.StudentFeignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/27 16:50
 */
@RestController
@RequestMapping("/lb/feign/consumer/student")
public class StudentController {

    @Resource
    private StudentFeignService  studentFeignService;

    /**
     * @description 服务消费者接口
     * @param stu
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2018/12/27 17:25
     */
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody @ApiParam(name = "新增学生",value = "传入json格式数据",required = true) Student stu){

        return studentFeignService.addStudent(stu);
    }

    /**
     * @description 服务消费者接口
     * @param stu
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2018/12/27 17:25
     */
    @PostMapping("/updateStudent")
    public String updateStudent(@RequestBody @ApiParam(name = "修改学生",value = "传入json格式数据",required = true) Student stu){

        return studentFeignService.updateStudent(stu);
    }
}
