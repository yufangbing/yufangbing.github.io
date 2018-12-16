package com.example.yu.demo.controller.timer;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * 跳舞机器人： 水满后，继续跳舞2s后停止工作
 */
public class DancingRobot extends TimerTask {

    @Override
    public void run() {
        //获取最近的一次任务的执行时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("最近一次执行时间" + sdf.format(scheduledExecutionTime()));
        System.out.println("跳舞真快乐！");
    }
}
