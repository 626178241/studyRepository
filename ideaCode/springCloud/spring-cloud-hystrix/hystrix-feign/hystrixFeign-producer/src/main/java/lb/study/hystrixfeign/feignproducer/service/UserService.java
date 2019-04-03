package lb.study.hystrixfeign.feignproducer.service;

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
    public String getUser(String name ){
        if("hystrix".equals(name)){
            return "请求正确得到结果";
        }else{
            throw new RuntimeException("错误，发生故障");
        }
    }

}
