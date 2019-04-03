package lb.study.hystrix.hystrixcache.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/29 9:36
 */
@FeignClient(name = "feign-producer")
public interface FeignService {
    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 16:38
     */
    @RequestMapping(value = "/lb/study/hystrix/producer/gerUser")
    String getUser(String name);
}
