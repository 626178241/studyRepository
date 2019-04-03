package lb.study.dashboard.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 浏览器：http://localhost:8080/hystrix
 * 输入：http://localhost:7072/actuator/hystrix.stream
 *
 * 只要有了那个包，加上以下（*可换为地址的包含字符）配置就能进行监控
 * #暴露全部的监控信息
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: "*"
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard //启用Hystrix Dashboard功能。
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
