package lb.study.hystrixfeign.feignconsumer.feign;

import lb.study.hystrixfeign.feignconsumer.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通过fallback配置fallback类
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 16:37
 */
@FeignClient(name = "hystrixFeign-producer",fallback = UserFeignFallback.class)
public interface UserFeign {

    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 16:38
     */
    @RequestMapping(value = "/lb/study/hystrix/producer/gerUser")
    String getUser(String name );
}
