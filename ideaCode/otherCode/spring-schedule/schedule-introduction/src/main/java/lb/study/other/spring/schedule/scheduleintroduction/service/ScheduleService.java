package lb.study.other.spring.schedule.scheduleintroduction.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 测试schedule定时调度
 * @author libo@citycloud.com.cn
 * @date 2019/4/2 10:24
 */
@Service
@Slf4j
public class ScheduleService {

    /**
     * cron规则：
     * https://blog.csdn.net/YoungLee16/article/details/88125977
     */
    private final static String cron_ten = "*/10 * * * * *";//每10秒执行一次（并不是项目部署完就开始算，而且在整0秒执行，例：10,20,30）


    /**
     * @description 正常获取数据
     * @param id
     * @return
     * @author libo@citycloud.com.cn
     * @date 2019/4/2 10:26
     */
    public String getStudent(Integer id ){
        log.info("getStudent()...................");
        return "李波";
    }

    @Scheduled(cron = cron_ten)
    public String scheduleUpdateStudent(){
        log.info("进来scheduleUpdateStudent()...................");
        return "LiBo............";
    }

    /**
     * 有没参数的方法可以用@Scheduled注释
     */
    //@Scheduled(cron = cron_ten)
    public String scheduleStudent(Integer id ){
        log.info("scheduleStudent()..................."+id);
        return getStudent(id);
    }

}
