package lb.study.hystrix.hystrixcache.controller;


import lb.study.hystrix.hystrixcache.service.HelloCommand;
import lb.study.hystrix.hystrixcache.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CacheController {
	private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

	@Autowired
	private HelloService helloService;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public String getUserId(@PathVariable("id") Integer id) {
		HelloCommand one = new HelloCommand(restTemplate,id);
		Object execute1 = one.execute();
		logger.info("第一次调用:   " + one.isResponseFromCache());
		HelloCommand two = new HelloCommand(restTemplate,id);
		Object execute2 = two.execute();
		logger.info("第二次调用:   " + two.isResponseFromCache());
		return execute1+"==="+execute2;
	}

	@RequestMapping(value = "/getHello/{id}", method = RequestMethod.GET)
	public String getHello(@PathVariable("id") Integer id){
		logger.info("第一次调用");
		helloService.hello(id);
		logger.info("第二次调用");
		helloService.hello(id);
		logger.info("第三次调用");
		helloService.hello(2);
		logger.info("第四次调用");
		helloService.hello(id);
		return "getHello成功";
	}

	/**
	 * @description 测试清除缓存
	 * @param id
	 * @return
	 * @author libo@citycloud.com.cn
	 * @date 2019/3/22 16:48
	 */
	@RequestMapping(value = "/testCacheRemove/{id}", method = RequestMethod.GET)
	public String testCacheRemove(@PathVariable("id") Integer id ){
		logger.info("调用接口并缓存数据........");
		helloService.getUser(id);
		helloService.getUser(id);
		logger.info("清除缓存...........");
		helloService.updateUser(id,"测试两个参数，cacheKey是否还一样");
		logger.info("再次调用接口并缓存..........");
		helloService.getUser(id);
		helloService.getUser(id);
		return "测试接口testCacheRemove（）成功!";
	}

	/**
	 * @description 测试使用hystrix缓存feign请求（在service中加@CacheResult缓存注解）
	 * @param name
	 * @return
	 * @author libo@citycloud.com.cn
	 * @date 2019/3/29 9:40
	 */
	@RequestMapping(value = "/testFeignCache", method = RequestMethod.POST)
	public String testFeignCache(String name ){
		logger.info("调用接口并缓存数据........");
		logger.info("第一次调用");
		helloService.testFeignCache(name);
		logger.info("第二次调用");
		helloService.testFeignCache(name);
		return "调用接口成功";
	}

	/**
	 * @description 测试使用hystrix缓存feign请求（在FeignClient方法上加@CacheResult缓存注解）
	 * 不行的，在FeignClient方法上加@CacheResult缓存注解就直接导致Feign报错了
	 * @param name
	 * @return
	 * @author libo@citycloud.com.cn
	 * @date 2019/3/29 9:40
	 */
	@RequestMapping(value = "/testFeignCache02", method = RequestMethod.POST)
	public String testFeignCache02(String name ){
		logger.info("调用接口并缓存数据........");
		logger.info("第一次调用");
		helloService.testFeignCache02(name);
		logger.info("第二次调用");
		helloService.testFeignCache02(name);
		return "调用接口成功";
	}
}
