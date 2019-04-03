package lb.study.hystrixfeign.feignproducer.controller;

import lb.study.hystrixfeign.feignproducer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 16:32
 */
@RestController
@RequestMapping(value = "/lb/study/hystrix/producer")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 16:32
     */
    @RequestMapping("/gerUser")
    public String getUser(@RequestBody String name ){
        return userService.getUser(name);
    }

}
