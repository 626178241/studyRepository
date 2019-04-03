package lb.study.springcloud.feignproducer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/13 16:33
 */
@Service
public class UserService {

    /**
     * @description
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/13 16:34
     */
    @HystrixCommand(fallbackMethod = "getUserDefa")
    public String getUser(String name ){
        if("hystrix".equals(name)){
            return "请求正确得到结果";
        }else{
            throw new RuntimeException("错误，发生故障");
        }
    }

    public String getUserDefa(String name ){
        return "name=="+name+"不正确";
    }
}
