package lb.study.hystrixfeign.hystrixfeigneurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HystrixfeignEurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixfeignEurekaserverApplication.class, args);
    }

}
