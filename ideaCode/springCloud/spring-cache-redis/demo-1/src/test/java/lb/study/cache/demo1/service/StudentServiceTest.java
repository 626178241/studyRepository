package lb.study.cache.demo1.service;

import lb.study.cache.demo1.Demo1Application;
import lb.study.cache.demo1.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/7 10:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo1Application.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testQueryStudentList(){
        List<Student> list = studentService.queryStudentList();

        for(Student stu : list ){
            System.out.println(stu);
        }
    }

    @Test
    public void queryStudentById(){
        Map<String,Object> map = studentService.queryStudentById(1L);
        for(String key : map.keySet()){
            System.out.println(key+":"+map.get(key));
        }
    }
}
