package lb.study.cache.demo1.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/7 10:22
 */
@Data
public class Student implements Serializable {

    private Long stuId;

    private Integer stuAge;

    private String stuName;

    private String stuClass;
}
