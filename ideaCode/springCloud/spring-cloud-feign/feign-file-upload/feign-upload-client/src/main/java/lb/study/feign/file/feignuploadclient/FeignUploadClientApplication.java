package lb.study.feign.file.feignuploadclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignUploadClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignUploadClientApplication.class, args);
    }

}

