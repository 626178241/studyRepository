package lb.study.other.quartz.ramquartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 *  要由表示要执行的“作业”的类实现的接口。只有一个方法 void execute(jobExecutionContext context)
 * (jobExecutionContext 提供调度上下文各种信息，运行时数据保存在jobDataMap中)
 *
 * Job有个子接口StatefulJob ,代表有状态任务。有状态任务不可并发，前次任务没有执行完，后面任务处于阻塞等到。
 *
 * @author libo@citycloud.com.cn
 * @date 2019/5/24 13:56
 */
@Slf4j
public class RAMJob implements Job {

    /**
     *
     * @param jobExecutionContext:提供调度上下文各种信息，运行时数据保存在jobDataMap中
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("job开始......."+new Date());
    }
}
