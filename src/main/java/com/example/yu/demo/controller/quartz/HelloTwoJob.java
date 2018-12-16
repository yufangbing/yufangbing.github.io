package com.example.yu.demo.controller.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloTwoJob implements Job {

    //1. 通过JobExecutionContext获取job,triggle,和自定义传人的相关参数值

    //2.Job实现类中添加setter方法对应JobDataMap的键值
    //（Quartz框架默认的JobFactory实现类在初始化job实例对象时会自动地调用这些setter方法）
    private String message;
    private Float FloatJobValue;
    private Double DoubleTriggerValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobValue() {
        return FloatJobValue;
    }

    public void setFloatJobValue(Float floatJobValue) {
        FloatJobValue = floatJobValue;
    }

    public Double getDoubleTriggerValue() {
        return DoubleTriggerValue;
    }

    public void setDoubleTriggerValue(Double doubleTriggerValue) {
        DoubleTriggerValue = doubleTriggerValue;
    }
    //2 结束=========================

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        JobKey key = context.getJobDetail().getKey();
        System.out.println("jobName:"+key.getName()+"jobGroup："+key.getGroup());
        TriggerKey trkey = context.getTrigger().getKey();
        System.out.println("triggerName:"+trkey.getName()+"triggerGroup:"+trkey.getGroup());

        //1.
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        JobDataMap  tdataMap = context.getTrigger().getJobDataMap();
        String jobMsg = dataMap.getString("message");
        Float floatJobValue = dataMap.getFloat("FloatJobValue");
        String triggerMsg = tdataMap.getString("message");
        Double doubleTriggerValue = tdataMap.getDouble("DoubleTriggerValue");
        System.out.println("jobMsg:"+jobMsg);
        System.out.println("floatJobValue:"+floatJobValue);
        System.out.println("triggerMsg:"+triggerMsg);
        System.out.println("doubleTriggerValue:"+doubleTriggerValue);

        //合并一起，若job和trigger中有参数key相同，trigger中的key会覆盖job中的key
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String jobMsgTwo = jobDataMap.getString("message");
        Float floatJobValueTwo = jobDataMap.getFloat("FloatJobValue");
        Double doubleTriggerValueTwo = jobDataMap.getDouble("DoubleTriggerValue");

        //2.
        System.out.println("message:"+message);
        System.out.println("FloatJobValue:"+FloatJobValue);
        System.out.println("DoubleTriggerValue:"+DoubleTriggerValue);

    }
}
