package lb.study.feigngzip.controller;

import lb.study.feigngzip.client.TestFeignClient;
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
@RequestMapping("/lb/gzip")
public class TestGZIPController {

    @Resource
    private TestFeignClient testFeignClient;

    @RequestMapping("/testGZIP")
    public ResponseEntity<byte[]> testGZIP(@RequestParam("str") String str){
        return testFeignClient.testGZIP(str);
    }
}
