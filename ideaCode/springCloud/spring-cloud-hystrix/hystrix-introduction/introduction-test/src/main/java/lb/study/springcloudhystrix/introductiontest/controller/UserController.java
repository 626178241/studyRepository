package lb.study.springcloudhystrix.introductiontest.controller;

import lb.study.springcloudhystrix.introductiontest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 14:54
 */
@RestController
@RequestMapping(value = "/lb/study/hystrix/introduction")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 14:56
     */
    @RequestMapping("/gerUser")
    public String getUser(String name ){
        return userService.getUser(name);
    }

}
