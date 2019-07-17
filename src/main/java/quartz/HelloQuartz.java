package quartz;

import java.util.List;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloQuartz {

    public static void main(String[] args) {

        try {
            // 从Scheduler工厂获取一个Scheduler的实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            
            scheduler.start();
            /**
             * 重用HelloJob，实现不同实例
             */
            // 注册jobDetail1，打印"Hello Quartz!"，第5秒钟执行一次
            JobDetail jobDetail1 = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group").build();
            jobDetail1.getJobDataMap().put("CONTENT", "Hello Quartz!");
            Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "group").startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5)).build();
            scheduler.scheduleJob(jobDetail1, trigger1);
            // 注册jobDetail2，打印当前系统时间，每10秒钟执行一次
            JobDetail jobDetail2 = JobBuilder.newJob(HelloJob.class).withIdentity("job2", "group").build();
            jobDetail2.getJobDataMap().put("CONTENT", String.valueOf(System.currentTimeMillis()));
            Trigger trigger2 =TriggerBuilder.newTrigger().withIdentity("trigger2", "group").startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();
            scheduler.scheduleJob(jobDetail2, trigger2);
           List<String> names =  scheduler.getJobGroupNames();
           System.out.println("JobGroupNames"+names);
        } catch (SchedulerException e) {
            System.out.println(e.getMessage());
        }
    }

}
