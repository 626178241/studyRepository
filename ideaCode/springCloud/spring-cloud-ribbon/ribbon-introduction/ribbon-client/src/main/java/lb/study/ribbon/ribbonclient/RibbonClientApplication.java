package lb.study.ribbon.ribbonclient;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import lb.study.ribbon.ribbonclient.controller.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "test-client",configuration = TestConfiguration.class)//对源服务名为“test-client”的服务进行特定的策略约束
// 【这里需要避免扫描TestConfiguration的类，不然会产生全局的导致冲突报错】
public class RibbonClientApplication {

    /**
     * 需要注入RestTemplate的bean，并添加注解@LoadBalanced，声明该RestTemplate用于负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //全局策略模式设置
    /*@Bean
    public IRule ribbonRule(){
        return new RandomRule();//随机策略
    }*/

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientApplication.class, args);
    }

}

