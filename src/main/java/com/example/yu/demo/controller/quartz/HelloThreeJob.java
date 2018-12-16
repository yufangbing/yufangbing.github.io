package com.example.yu.demo.controller.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloThreeJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        Trigger currentTrigger = context.getTrigger();
        System.out.println("startTime : " + currentTrigger.getStartTime());
        System.out.println("startTime : " + currentTrigger.getEndTime());

        JobKey jobKey = currentTrigger.getJobKey();
        System.out.println("jobKey info : name " + jobKey.getName() +"group:"+ jobKey.getGroup());


    }
}
