package lb.study.other.quartz.jdbcquartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author libo@citycloud.com.cn
 * @date 2019/5/24 15:01
 */
@Slf4j
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("job开始..............");
        log.info("执行内容.............."+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));
        log.info("job结束..............");
    }
}
