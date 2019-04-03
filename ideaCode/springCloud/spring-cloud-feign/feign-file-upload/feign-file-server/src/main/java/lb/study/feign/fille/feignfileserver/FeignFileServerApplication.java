package lb.study.feign.fille.feignfileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignFileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignFileServerApplication.class, args);
    }

}

