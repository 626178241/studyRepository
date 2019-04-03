package lb.study.eurekaclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author libo@citycloud.com.cn
 * @date 2018/11/7 10:31
 */
@RequestMapping("/query")
public class TestController {

    @Autowired
    private EurekaClientConfigBean eurekaClientConfigBean;

    /** 打印出当前到底有多少个 eureka-server实例在提供服务（从而可以直观的判断出 eureka-server的扩容是否已经成功）
     * @description
     * @param
     * @return java.lang.Object
     * @author libo@citycloud.com.cn
     * @date 2018/11/7 10:35
     */
    @GetMapping("/eureka-server")
    public Object getEurekaServerUrl(){
        return eurekaClientConfigBean.getServiceUrl();
    }
}
