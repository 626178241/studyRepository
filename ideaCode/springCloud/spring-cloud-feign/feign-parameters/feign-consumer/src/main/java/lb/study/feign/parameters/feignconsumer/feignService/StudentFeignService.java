package lb.study.feign.parameters.feignconsumer.feignService;

import lb.study.feign.parameters.feignconsumer.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/27 17:19
 */
@FeignClient(name = "feign-provider")
public interface StudentFeignService {

    /**
     * @description 这里使用get请求服务提供者，多参数传递
     * @param stu
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2018/12/27 17:24
     */
    @GetMapping("/lb/feign/provider/student/addStudent")
    String addStudent(Student stu );

    /**
     * @description 这里使用post请求服务提供者，多参数传递
     * @param stu
     * @return java.lang.String
     * @author libo@citycloud.com.cn
     * @date 2018/12/27 17:25
     */
    @PostMapping("/lb/feign/provider/student/updateStudent")
    String updateStudent(@RequestBody Student stu);
}
