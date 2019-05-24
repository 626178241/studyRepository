package lb.study.other.quartz.jdbcquartz.quartz;

import lb.study.other.quartz.jdbcquartz.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author libo@citycloud.com.cn
 * @date 2019/5/24 15:04
 */
public class QuartzJdbcTest {

    public static void main(String[] args) throws SchedulerException {
        test01();
    }

    /**
     * SimpleTrigger：用来触发只需执行一次或者在给定时间触发并且重复N次且每次执行延迟一定时间的任务。
     * CronTrigger：按照日历触发，例如“每个周五”，每个月10日中午或者10：15分。
     */
    public static void test01() throws SchedulerException {
        //创建触发器类型
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .repeatHourlyForTotalCount(5);//执行次数

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)// 任务执行类MyJob
                // 任务名，任务组
                .withIdentity("job1_1", "jGroup1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(simpleScheduleBuilder)//指定触发器
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //启动调度器
        scheduler.start();
        //注册任务和定时器
        scheduler.scheduleJob(jobDetail,trigger);//似乎随便什么时候注册任务进去
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //关闭调度器
        scheduler.shutdown();
    }
}
