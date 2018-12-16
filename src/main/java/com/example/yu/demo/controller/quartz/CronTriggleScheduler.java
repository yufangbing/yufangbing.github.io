package com.example.yu.demo.controller.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CronTrigger作用：
 *  基于日历的作业调度器，而不是像SimpleTrigger那样精确指定时间间隔，
 *  比SimpleTrigger更常用
 * Cron表达式（强大的任务调度能力，用于配置CronTrigger实例,注：可以在线生成）
 */
public class CronTriggleScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        // 创建一个JobDetail实例，将该实例与HelloJob Class绑定  并传人相关参数和值
        JobDetail jobDetail = JobBuilder.newJob(CronTriggerJob.class).withIdentity("myJob").build();   //Builder模式

        //创建一个CronTrigger实例
        CronTrigger trigger = (CronTrigger)TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("* * * * * ? *")).build();
        // 创建Scheduler实例
        SchedulerFactory sfact = new StdSchedulerFactory(); //工厂模式
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
        //scheduler执行2秒后挂起
        Thread.sleep(2000L);
        scheduler.standby();    //standby挂起，是可以重新开启
        //scheduler挂起3秒后重新启动
        Thread.sleep(3000L);
        scheduler.start();
        //shutdown(true)表示等待所有正在执行的job执行完毕之后，再关闭scheduler
        //shutdown(false)即shutdown()表示直接关闭scheduler
        //shutdown后不能重启start
        scheduler.shutdown(false);

    }
}
