package lb.study.ribbon.ribbonclient.controller;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 用来配置策略模式
 * @author libo@citycloud.com.cn
 * @date 2019/2/22 17:11
 */
//@Configuration
public class TestConfiguration {

    @Autowired
    private IClientConfig clientConfig;

    /**
     * @description 注入的IClientConfig是针对客户端的配置管理器
     * @param config
     * @return com.netflix.loadbalancer.IRule
     * @author libo@citycloud.com.cn
     * @date 2019/2/22 17:14
     */
    @Bean
    public IRule ribbonRule(IClientConfig config ){
        return new RandomRule();
    }
}
