package com.example.yu.demo.controller.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    private String name;

    private Integer count = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  MyTimerTask(String inputName){
        name = inputName;
    }

    @Override
    public void run() {  //执行业务逻辑
        if(count < 3){
            //打印当前执行时间
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("time:"+sdf.format(calendar.getTime()));

            //打印当前name的内容
            System.out.println("name:"+name);
            count++;
        }else{
            cancel();    //取消当前TimerTask里的任务
            System.out.println("任务执行次数达到3次了，现在已经取消了Task");
        }


    }
}
