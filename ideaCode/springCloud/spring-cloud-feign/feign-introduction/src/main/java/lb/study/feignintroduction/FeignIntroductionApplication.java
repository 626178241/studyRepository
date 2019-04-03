package lb.study.feignintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //表示当程序启动时，会进行包扫描，扫描所有带FeignClient的注解类并处理
public class FeignIntroductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignIntroductionApplication.class, args);
    }

}

