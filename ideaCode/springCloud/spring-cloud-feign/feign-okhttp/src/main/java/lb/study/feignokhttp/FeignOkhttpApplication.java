package lb.study.feignokhttp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 使用okHttp替换Feign默认的（使用JDK原生的URLConnection发送HTTP请求）请求方式
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOkhttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignOkhttpApplication.class, args);
    }

}

