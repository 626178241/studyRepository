package lb.study.hystrixfeign.feignconsumer.fallback;

import lb.study.hystrixfeign.feignconsumer.feign.UserFeign;
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
        return "消费者：访问hystrixFeign-producer接口出错";
    }

}
