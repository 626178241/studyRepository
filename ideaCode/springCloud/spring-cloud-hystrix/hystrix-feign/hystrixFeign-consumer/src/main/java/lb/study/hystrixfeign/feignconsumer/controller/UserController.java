package lb.study.hystrixfeign.feignconsumer.controller;

import lb.study.hystrixfeign.feignconsumer.feign.UserFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 16:36
 */
@RestController
@RequestMapping(value = "/lb/study/hystrix/consumer")
public class UserController {

    @Resource
    private UserFeign userFeign;

    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 16:32
     */
    @RequestMapping("/gerUser")
    public String getUser(String name ){
        return userFeign.getUser(name);
    }
}
