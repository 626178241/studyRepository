package lb.study.springcloud.feignproducer.controller;

import lb.study.springcloud.feignproducer.feign.ServiceFeign;
import lb.study.springcloud.feignproducer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 16:32
 */
@RestController
@RequestMapping(value = "/lb/study/hystrix/producer")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /*@Resource
    private ServiceFeign serviceFeign;*/

    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 16:32
     */
    @RequestMapping("/gerUser")
    public String getUser(@RequestBody String name ){
        logger.info("调用feign-producer...........getUser（）方法");
        return userService.getUser(name);
    }

    @RequestMapping("/gerUser/{id}")
    public String getUser(@PathVariable Integer id ){
        System.out.println("ProviderController, id is" +id);
        if (id == 1) {
            return "Toy,123456, 10";
        } else if (id == 2) {
            return "Sky, 000000, 20";
        }
        return "San, 543210, 30";
    }

    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/14 15:57
     */
    /*@RequestMapping("/getService")
    public String getService(String name ){
        return serviceFeign.getService(name);
    }*/
}
