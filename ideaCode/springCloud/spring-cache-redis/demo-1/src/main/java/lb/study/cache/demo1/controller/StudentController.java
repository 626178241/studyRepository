package lb.study.cache.demo1.controller;

import lb.study.cache.demo1.entity.Student;
import lb.study.cache.demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/7 11:39
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/queryStudentList")
    public List<Student> queryStudentList(){
        return studentService.queryStudentList();
    }

    @RequestMapping("/queryStudentById")
    public Map<String,Object> queryStudentById(Long stuId){
        return studentService.queryStudentById(stuId);
    }

    @RequestMapping("/findStudentById")
    public Student findStudentById(Long stuId){
        return studentService.findStudentById(stuId);
    }

    @PostMapping("/updateStudentById")
    public Integer updateStudentById(Student stu){
        return studentService.updateStudentById(stu);
    }

    @PostMapping("/updateStudent")
    public Integer updateStudent(Long stuId){
        return studentService.updateStudent(stuId);
    }
}
