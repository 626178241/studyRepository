package lb.study.other.quartz.ramquartz.quartz;

import lb.study.other.quartz.ramquartz.job.RAMJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/24 14:09
 */
@Slf4j
public class RAMQuartz {

    public static void main(String[] args) throws SchedulerException {
        new RAMQuartz().test01();
    }

    /**
     * test01
     */
    public void test01() throws SchedulerException {
        //1、创建SchedulerFactory ：提供用于获取调度程序实例的客户端可用句柄的机制
        SchedulerFactory sf = new StdSchedulerFactory();
        //2、获取scheduler：这是Quartz Scheduler的主要接口，代表一个独立运行容器。调度程序维护JobDetails和触发器的注册表。 一旦注册，调度程序负责执行作业，当他们的相关联的触发器触发（当他们的预定时间到达时）
        Scheduler scheduler = sf.getScheduler();

        //3、创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(RAMJob.class)
                .withDescription("job的描述")
                .withIdentity("job 的name","job 的group")//job 的name和group
                .build();

        long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动任务
        Date statTime = new Date(time);

        //4、创建Trigger：具有所有触发器通用属性的基本接口，描述了job执行的时间出发规则。 - 使用TriggerBuilder实例化实际触发器。
        Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription("Trigger的描述")
                .withIdentity("Trigger的name","Trigger的group")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))//从0秒开始  每隔3秒执行一次
                .startAt(statTime)//设置开始时间（默认为当前时间）
                .build();
        //5、注册任务和定时器
        scheduler.scheduleJob(jobDetail,trigger);
        //6、启动调度器
        scheduler.start();

        log.info("启动时间  --------"+new Date());
    }
}

