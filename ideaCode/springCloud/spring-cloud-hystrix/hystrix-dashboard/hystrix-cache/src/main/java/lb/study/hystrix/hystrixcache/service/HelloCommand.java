package lb.study.hystrix.hystrixcache.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/18 16:59
 */
public class HelloCommand extends HystrixCommand {

    private RestTemplate restTemplate;

    private Integer id;

    public HelloCommand(RestTemplate restTemplate,Integer id) {
        super(HystrixCommandGroupKey.Factory.asKey("springCloudCacheGroup"));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    protected String getFallback() {
        System.out.println("进入了getFallback方法................");
        return "fallback";
    }

    @Override
    protected Object run() throws Exception {
        System.out.println("run开始调用...............");
        String json = restTemplate.getForObject("http://feign-producer/lb/study/hystrix/producer/gerUser/{1}",String.class, id);
        if(true){
            System.out.println("跑个异常......");
            throw new RuntimeException("来个异常...");
        }
        System.out.println(json);
        return json;
    }

    @Override
    protected String getCacheKey() {
        System.out.println("调用getCacheKey");//打印一下什么时候会触发
        return String.valueOf(id);
    }
}
