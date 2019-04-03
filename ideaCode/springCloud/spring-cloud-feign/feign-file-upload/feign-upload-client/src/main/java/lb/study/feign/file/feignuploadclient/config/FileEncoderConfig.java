package lb.study.feign.file.feignuploadclient.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * Feign文件上传Configuration
 * Feign是不支持文件的，这里用的是Encoder实现
 * @author libo@citycloud.com.cn
 * @date 2019/1/7 10:13
 */
@Configuration
public class FileEncoderConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder initEncoder(){
        return new SpringFormEncoder();
    }
}
