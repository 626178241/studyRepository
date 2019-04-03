package lb.study.springcloud.hystrix.hystrixcollapsing.controller;

import lb.study.springcloud.hystrix.hystrixcollapsing.entity.Animal;
import lb.study.springcloud.hystrix.hystrixcollapsing.service.CollapsingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/3/29 16:17
 */
@RestController
@RequestMapping("/hystrix/collapsing")
public class CollapsingController {

    private static final Logger logger = LoggerFactory.getLogger(CollapsingController.class);

    @Autowired
    private CollapsingService collapsingService;

    @RequestMapping("/getAnimal")
    public String getAnimal() throws ExecutionException, InterruptedException {
        Future<Animal> collapsing01 = collapsingService.collapsing(1);
        Future<Animal> collapsing02 = collapsingService.collapsing(2);
        logger.info(collapsing01.get().toString());
        logger.info(collapsing02.get().toString());
        return "success";
    }

    /**
     * @description 合并多次请求
     * @param id
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/3/29 16:45
     */
    @RequestMapping("/collapsingGlobal")
    public String collapsingGlobal(Integer id ) throws ExecutionException, InterruptedException {
        Future<Animal> collapsing = collapsingService.collapsingGlobal(id);
        logger.info(collapsing.get().toString());
        return collapsing.get().toString();
    }
}
