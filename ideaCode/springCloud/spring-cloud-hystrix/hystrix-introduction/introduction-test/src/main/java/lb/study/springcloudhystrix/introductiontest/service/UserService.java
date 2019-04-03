package lb.study.springcloudhystrix.introductiontest.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 14:53
 */
@Service
public class UserService {

    /**
     * @description 测试-当发生错误时调用defaultUser
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 14:59
     */
    @HystrixCommand(fallbackMethod = "defaultUser")//增加@HystrixCommand和降级fallback
    public String getUser(String name ){
        if("hystrix".equals(name)){
            return "请求正确得到结果";
        }else{
            throw new RuntimeException("错误，发生故障");
        }
    }

    /**
     * @description 出错则调用该方法返回友好错误
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 15:00
     */
    public String defaultUser(String name ){
       return "hystrix：没有找到该user用户=="+name;
    }
}
