package lb.study.springcloud.hystrix.hystrixcollapsing.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lb.study.springcloud.hystrix.hystrixcollapsing.entity.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import static com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/29 15:26
 */
@Service
public class CollapsingService {

    private static final Logger logger = LoggerFactory.getLogger(CollapsingService.class);

    /**
     * @description 测试合并请求，当多次请求此方法时，合并value=？时间内的请求
     * -------这里是针对同一个请求中合并，想要在不同请求（不同线程），需要加上配置Scope：默认是Request，另一个是Global
     * @param id
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/29 16:23
     */
    @HystrixCollapser(batchMethod = "collapsingList",collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds",value = "2000")
    })
    public Future<Animal> collapsing(Integer id ){
        /**
         * @HystrixCollapser 注解代表开启请求合并，调用该方法时，实际上调用的是collapsingList方法，
         * @HystrixProperty 声明的timerDelayInMilliseconds属性1000的意思是合并1ms内的请求
         *
         */
        return null;
    }

    /**
     * 合并不同线程的请求
     * @param id
     * @return
     */
    @HystrixCollapser(batchMethod = "collapsingList",scope = GLOBAL,collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds",value = "5000")
    })
    public Future<Animal> collapsingGlobal(Integer id ){
        /**
         * @HystrixCollapser 注解代表开启请求合并，调用该方法时，实际上调用的是collapsingList方法，
         * @HystrixProperty 声明的timerDelayInMilliseconds属性1000的意思是合并1ms内的请求
         *
         */
        return null;
    }

    /**
     * @description 将两次请求合并一起请求
     * @param idList 存放两次请求的参数
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/29 16:25
     */
    @HystrixCommand
    public List<Animal> collapsingList(List<Integer> idList ){
        logger.info("collapsingList当前线程："+Thread.currentThread().getName());
        logger.info("当前请求参数个数："+idList.size());
        List<Animal> list = new ArrayList();
        for(Integer id : idList){
            Animal animal = new Animal();
            animal.setId(id);
            animal.setName("name=="+id);
            animal.setType("type=="+id);
            list.add(animal);
        }
        return list;
    }
}
