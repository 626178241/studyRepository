package lb.study.springcloud.hystrix.hystrixcollapsing.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/29 16:15
 */
@Data
@ToString
public class Animal {
    private Integer id;
    private String type;
    private String name;
}
