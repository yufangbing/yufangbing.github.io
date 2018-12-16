package com.example.yu.demo.controller.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Quartz定时任务
 * 1.主要用到的设计模式
 * Builder模式   组件模式
 * Factory模式   链式写法
 * 2.强大的调度功能，灵活的应用方式，分布式和集群能力
 * 3.三个核心概念
 *      调度器（scheduler：将jobDetail和trigger绑定在一起，）
 *      任务（jobDetail：任务的实现类）
 *      触发器（trigger
 *          1.SimpleTriggle:在一个指定时间段内执行一次作业任务或是在指定的时间间隔内多次执行作业任务
 *
 *      ）
 * 4.重要组成
 *      Job 接口：实现该接口，定义运行任务，JobDetail，JobBuilder，JobStore
 *      Trigger类，TriggerBuilder创建触发器的实例
 *      ThreadPoll
 *      Scheduler代表Quartz独立运行容器
 *      Calendar：一个Trigger可以和多个Calendar关联，以排除或包含某些时间点
 *      监听器：JobListener，TriggerListener，SchedulerListener
 *
 *
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        // 创建一个JobDetail实例，将该实例与HelloJob Class绑定
        //name:任务的名称 group：任务的组 jobClass—— HelloJob.class
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob","group1").build();   //Builder模式
        //可以查看名称，组，Class，可以获取名称，组去动态判断该执行哪一套逻辑
        System.out.println("JobDetail's name:" + jobDetail.getKey().getName());
        System.out.println("JobDetail's group:" + jobDetail.getKey().getGroup());
        System.out.println("JobDetail's class:" + jobDetail.getKey().getClass());


        //创建一个Trigger实例，定义该job立即执行，并且每隔2秒重复执行一次，直到永远
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever()).build();
        // 创建Scheduler实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        scheduler.scheduleJob(jobDetail,trigger);
    }
}
