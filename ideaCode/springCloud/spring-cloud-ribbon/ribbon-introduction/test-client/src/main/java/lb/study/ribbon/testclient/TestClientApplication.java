package lb.study.ribbon.testclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//mvn spring-boot:run -Dspring.profiles.active=zone1
@SpringBootApplication
@EnableEurekaClient
public class TestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestClientApplication.class, args);
    }

}

