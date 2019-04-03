package lb.study.feignintroduction.controller;

import lb.study.feignintroduction.client.HelloFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/12/25 17:01
 */
@RestController
@RequestMapping("/lb")
public class HelloController {

    @Resource
    private HelloFeignClient helloFeignClient;

    @RequestMapping("/search/github")
    public String search(@RequestParam("str") String queryStr){
        return helloFeignClient.searchRepo(queryStr);
    }
}
