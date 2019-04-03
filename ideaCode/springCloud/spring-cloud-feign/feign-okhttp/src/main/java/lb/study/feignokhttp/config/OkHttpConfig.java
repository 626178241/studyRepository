package lb.study.feignokhttp.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 这是第二种方式，替换Feign默认的Client
 * @author libo@citycloud.com.cn
 * @date 2018/12/26 18:13
 */
@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient createOkHttp(){
        return new OkHttpClient.Builder()
                //设置链接超时
                .connectTimeout(60,TimeUnit.SECONDS)
                //设置读超时
                .readTimeout(60, TimeUnit.SECONDS)
                //设置写超时
                .writeTimeout(60,TimeUnit.SECONDS)
                //是否自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool())
                .build();
    }
}
