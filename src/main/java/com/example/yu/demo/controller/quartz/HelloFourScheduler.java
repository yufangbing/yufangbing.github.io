package com.example.yu.demo.controller.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *1.SimpleTriggle:在一个指定时间段内执行一次作业任务
 * 或是在指定的时间间隔内多次执行作业任务
 */
public class HelloFourScheduler {
    public static void main(String[] args) throws SchedulerException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        // 创建一个JobDetail实例，将该实例与HelloJob Class绑定  并传人相关参数和值
        JobDetail jobDetail = JobBuilder.newJob(HelloFourJob.class).withIdentity("myJob").build();   //Builder模式

        //获取距离当前时间4s后的时间
        date.setTime(date.getTime() + 4000);
        //获取距离当前时间6s后的时间
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000);

        //距离当前时间4s后执行且只执行一次
        SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(date)
                .build();

        //距离当前时间4s后执行且每个2秒执行一次
        SimpleTrigger triggerTwo = (SimpleTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2).withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))
                .build();

        //距离当前时间4s后执行且每个2秒执行一次，连续执行3次
        SimpleTrigger triggerThree = (SimpleTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2).withRepeatCount(3))
                .build();

        //距离当前时间4s后执行且每个2秒执行一次，连续执行3次，6s中停止执行(注：这种会优先6秒结束，只会执行1次)
        SimpleTrigger triggerFour = (SimpleTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(date)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2).withRepeatCount(3))
                .build();


        // 创建Scheduler实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
