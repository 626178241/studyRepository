package lb.study.cache.demo1.dao;

import lb.study.cache.demo1.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/7 10:38
 */
@Mapper
public interface StudentMapper {

    @Select("select stu_id as stuId,stu_age as stuAge,stu_name as stuName,stu_class as stuClass from tb_student")
    List<Student> queryStudentList();

    Map<String,Object> queryStudentById(@Param("stuId") Long stuId );

    Student findStudentById(@Param("stuId") Long stuId);

    Integer updateStudentById(@Param("stu")Student stu );

    Integer updateStudent(@Param("stuId") Long stuId );


}
