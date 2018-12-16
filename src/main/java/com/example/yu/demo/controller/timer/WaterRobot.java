package com.example.yu.demo.controller.timer;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 灌水机器人: 每隔2秒钟灌水，水满停止
 */
public class WaterRobot extends TimerTask {

    private Timer timer;

    public WaterRobot(Timer inputTimer) {
        timer = inputTimer;
    }

    //最大容量为5L，每次灌水1L
    private  Integer bucketCapacity = 0;

    @Override
    public void run() {
        //灌水直至桶满为止
        if(bucketCapacity < 5){
            System.out.println("灌水1L");
            bucketCapacity++;
        }else{
            //水满后停止执行
            System.out.println("取消的任务数："+timer.purge());
            cancel();
            System.out.println("停止执行");
            System.out.println("取消的任务数："+timer.purge());
            System.out.println("当前水容量："+bucketCapacity +"L");
            //等待2s后，终止timer里面的所有内容
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel();
        }

    }
}
