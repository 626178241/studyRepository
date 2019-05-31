package lb.study.other.apache.httpclient.httpclienttest.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/31 11:48
 */
@Configuration
public class MyHttpClientConfig {

    @Bean
    public HttpClient getHttpClient(){
        return HttpClients.createDefault();
    }
}
