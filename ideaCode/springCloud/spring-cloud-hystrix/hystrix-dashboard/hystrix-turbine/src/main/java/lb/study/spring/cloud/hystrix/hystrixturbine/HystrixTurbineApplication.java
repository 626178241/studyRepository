package lb.study.spring.cloud.hystrix.hystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 浏览器访问：http://localhost:7073/hystrix
 * 输入：localhost:7073//turbine.stream
 * 用来集群监控
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
@EnableEurekaClient
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }

}
