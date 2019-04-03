package lb.study.springcloud.feignproducer.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/14 15:58
 */
//@FeignClient()
public interface ServiceFeign {

    String getService(String name );
}
