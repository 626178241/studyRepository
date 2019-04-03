package lb.study.feignintroduction.client;

import lb.study.feignintroduction.config.HelloFeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/25 16:57
 */
@FeignClient(name = "github-client", url = "https://api.github.com", configuration = HelloFeignClientConfig.class)
public interface HelloFeignClient {

    @RequestMapping(value = "/search/repositories",method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);
}
