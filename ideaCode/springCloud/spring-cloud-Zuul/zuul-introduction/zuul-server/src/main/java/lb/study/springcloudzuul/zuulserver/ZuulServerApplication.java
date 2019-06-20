package lb.study.springcloudzuul.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
/**
 * 在zuul使用ribbon实现负载，只要在配置文件中配置下就行了【配置clientName.ribbon.*即可】
 * 有趣的是这里不用像在ribbon中那样使用@LoadBalanced指定一个RestTemplate用于负载均衡
 * 可以这么想：
 * 在我之前写的ribbon案例中，是先调ribbon的controller，controller里用RestTemplate去调client的接口的，
 * 如果不用@LoadBalanced指定使用的RestTemplate，会报UnknownHostException异常，所以应该里面也会声明一个用@LoadBalanced指定使用的RestTemplate实例
 */
//eureka默认的负载为轮询
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

}
