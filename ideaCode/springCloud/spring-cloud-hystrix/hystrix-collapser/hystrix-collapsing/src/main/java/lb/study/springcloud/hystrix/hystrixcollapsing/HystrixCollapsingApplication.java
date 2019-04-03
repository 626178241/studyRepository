package lb.study.springcloud.hystrix.hystrixcollapsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class HystrixCollapsingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixCollapsingApplication.class, args);
    }

}
