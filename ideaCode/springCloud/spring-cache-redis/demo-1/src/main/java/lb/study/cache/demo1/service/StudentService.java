package lb.study.cache.demo1.service;

import lb.study.cache.demo1.dao.StudentMapper;
import lb.study.cache.demo1.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author libo@citycloud.com.cn
 * http://www.cnblogs.com/gdpuzxs/p/7222309.html
 * https://blog.csdn.net/whatlookingfor/article/details/51833378/
 * @date 2018/12/7 10:41
 */
@Service
//如果方法中写了value则已方法中的value为主
@CacheConfig(cacheNames = "student")
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Cacheable
    public List<Student> queryStudentList(){
        return studentMapper.queryStudentList();
    }

    /**
     * @description 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
     * key为value::key
     * 比如为：key=queryStudentById::2
     * @param stuId
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author libo@citycloud.com.cn
     * @date 2018/12/7 16:35
     */
    @Cacheable(value = "queryStudentById",key ="#p0")
    public Map<String,Object> queryStudentById(Long stuId){
        return studentMapper.queryStudentById(stuId);
    }

    /**
     * @description key也可以使用这个写法，或者对象.属性
     * @param stuId
     * @return lb.study.cache.demo1.entity.Student
     * @author libo@citycloud.com.cn
     * @date 2018/12/7 16:53
     */
    @Cacheable(value = "Student",key ="#stuId")
    public Student findStudentById(Long stuId ){
        return studentMapper.findStudentById(stuId);
    }

    /**
     * @description 这里不适用。因为update返回的是Integer类型，跟它key相同的是student类型，会报不能转换异常
     * 如果返回的类型也是student才行
     * @param stu
     * @return java.lang.Integer
     * @author libo@citycloud.com.cn
     * @date 2018/12/7 16:51
     */
    //@CachePut(value = "Student",key ="#stu.stuId")
    public Integer updateStudentById(Student stu ){
        return studentMapper.updateStudentById(stu);
    }

    /**
     * @description 缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合
     * 并不是清空value的所有缓存
     * @param stuId
     * @return java.lang.Integer
     * @author libo@citycloud.com.cn
     * @date 2018/12/7 16:50
     */
    @CacheEvict(value = "Student",key ="#stuId")
    public Integer updateStudent(Long stuId ){
        return studentMapper.updateStudent(stuId);
    }
}
