package lb.study.eurekaconfigdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EurekaConfigdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigdemoApplication.class, args);
    }
}
