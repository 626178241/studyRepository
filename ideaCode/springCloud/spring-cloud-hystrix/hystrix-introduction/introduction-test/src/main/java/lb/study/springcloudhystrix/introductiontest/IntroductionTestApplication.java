package lb.study.springcloudhystrix.introductiontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix //开启断路器注解
public class IntroductionTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntroductionTestApplication.class, args);
    }

}
