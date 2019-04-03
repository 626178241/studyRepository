package lb.study.feignokhttp.controller;

import lb.study.feignokhttp.client.TestFeignClient;
import okhttp3.OkHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/26 11:24
 */
@RestController
@RequestMapping("/lb/okHttp")
public class TestOkHttpController {

    @Resource
    private TestFeignClient testFeignClient;

    @Resource
    private OkHttpClient okHttpClient;

    @RequestMapping("/testOkHttp")
    public ResponseEntity<byte[]> testOkHttp(@RequestParam("str") String str){
        System.out.println("=================="+okHttpClient);
        return testFeignClient.testOkHttp(str);
    }
}
