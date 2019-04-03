package lb.study.hystrix.feign.hystrixfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class HystrixFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignConsumerApplication.class, args);
    }

}
