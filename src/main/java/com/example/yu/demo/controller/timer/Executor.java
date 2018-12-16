package com.example.yu.demo.controller.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Timer;

/**
 * 二个机器人的问题
 */
public class Executor {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //获取当前的时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间："+sdf.format(calendar.getTime()));

        DancingRobot dr = new DancingRobot();
        WaterRobot wr = new WaterRobot(timer);
        timer.schedule(dr,calendar.getTime(),2000);
        timer.scheduleAtFixedRate(wr,calendar.getTime(),1000);
    }
}
