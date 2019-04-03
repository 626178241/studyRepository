package lb.study.ribbon.ribbonclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/1/9 17:24
 */
@RestController
@RequestMapping("/lb/study/ribbon/introduction")
public class RibbonController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/testRibbon")
    public String testRibbon(Integer a, Integer b){
        String result = restTemplate.getForObject("http://test-client/lb/study/ribbon/introduction/test?a="+a+"&b="+b,
                String.class);
        System.out.println(result+"----------");
        return result;
    }
}
