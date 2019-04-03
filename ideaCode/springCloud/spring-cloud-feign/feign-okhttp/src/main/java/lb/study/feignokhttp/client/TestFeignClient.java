package lb.study.feignokhttp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/26 11:24
 */
@FeignClient(name = "github-client", url = "https://api.github.com")
public interface TestFeignClient {

    @RequestMapping(value = "/search/repositories",method = RequestMethod.GET)
    ResponseEntity<byte[]> testOkHttp(@RequestParam("q") String str);
}
