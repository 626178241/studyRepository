package lb.study.springcloud.helloservice.fallback;

import lb.study.springcloud.helloservice.feign.UserFeign;
import org.springframework.stereotype.Component;

/**
 * userFeign降级fallback类
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 16:40
 */
@Component
public class UserFeignFallback implements UserFeign {


    @Override
    public String getUser(String name) {
        return "消费者：访问feign-producer接口出错";
    }

}
