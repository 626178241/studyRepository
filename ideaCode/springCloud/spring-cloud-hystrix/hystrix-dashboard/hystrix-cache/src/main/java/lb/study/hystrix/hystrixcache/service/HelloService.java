package lb.study.hystrix.hystrixcache.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 使用注解开启Hystrix缓存跟删除缓存
 * @author libo@citycloud.com.cn
 * @date 2019/3/22 15:56
 */
@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private FeignService feignService;

    /**
     * @description 测试缓存
     * @param id
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/22 16:42
     */
    @CacheResult
    @HystrixCommand(commandKey = "hello")
    public String hello(Integer id ){
        String json = restTemplate.getForObject("http://feign-producer/lb/study/hystrix/producer/gerUser/{1}",String.class, id);
        logger.info("=======调用hello==========="+json);
        return json;
    }

    /**
     * @description 测试缓存,带个commandKey指定hystrixCommand的Key
     * @param id
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/22 16:42
     */
    @CacheResult//标记一个方法的返回结果应被缓存。此注释必须与HystrixCommand配合使用。
    @HystrixCommand(commandKey = "getUser")
    public String getUser(@CacheKey Integer id ){
        /** @CacheKey
         * 将方法的参数标记为缓存的key。 如果没有标记参数，则使用所有参数。 如果@CacheResult或@CacheRemove annotation指定了cacheKeyMethod，
         * 那么方法参数不会用于构建缓存的key，即使它们用@CacheKey注解
         */
        String json = restTemplate.getForObject("http://feign-producer/lb/study/hystrix/producer/gerUser/{1}",String.class, id);
        logger.info("======调用getUser（）============"+json);
        return json;
    }

    /**
     * @description 测试清除缓存,带个commandKey清除指定参数
     * 如果没有加@CacheKey,则使用所有参数。  比如：我在这里的id加上@CacheKey，这样就能跟getUser（）的commandKey一样
     * @param id
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/22 16:42
     */
    @CacheRemove(commandKey = "getUser")//标记用于使命令的高速缓存无效的方法。 生成的缓存密钥必须与在链接CacheResult上下文中生成的密钥相同
    @HystrixCommand
    public void updateUser(@CacheKey Integer id,String str ){
        logger.info("清除缓存updateUser.......");
    }

    /**
     * @description 测试使用hystrix缓存feign请求
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/29 9:41
     */
    @CacheResult
    @HystrixCommand
    public String testFeignCache(String name ){
        String libo = feignService.getUser(name);
        logger.info("======调用testFeignCache（）============"+libo);
        return libo;
    }

    /**
     * @description 测试使用hystrix缓存feign请求（在FeignClient方法上加@CacheResult缓存注解）
     * 不行的，在FeignClient方法上加@CacheResult缓存注解就直接导致Feign报错了
     * @param name
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/29 9:40
     */
    public String testFeignCache02(String name ){
        String libo = feignService.getUser(name);
        //logger.info("======调用testFeignCache02（）============"+libo);
        return libo;
    }
}
