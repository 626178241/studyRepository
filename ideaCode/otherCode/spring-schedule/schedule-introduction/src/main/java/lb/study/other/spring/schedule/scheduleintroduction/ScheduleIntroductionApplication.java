package lb.study.other.spring.schedule.scheduleintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //加上这个注解就行了，就可以使用了
public class ScheduleIntroductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleIntroductionApplication.class, args);
    }

}
