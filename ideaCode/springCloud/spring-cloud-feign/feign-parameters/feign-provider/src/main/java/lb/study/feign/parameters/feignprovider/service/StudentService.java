package lb.study.feign.parameters.feignprovider.service;

import lb.study.feign.parameters.feignprovider.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/27 17:32
 */
@Service
public class StudentService {

    public String addStudent(Student stu){

        System.out.println("===========provider新增成功");
        System.out.println(stu);
        return "新增成功";
    }

    public String updateStudent(Student stu){
        System.out.println("===========provider修改成功");
        System.out.println(stu);
        return "修改成功";
    }
}
