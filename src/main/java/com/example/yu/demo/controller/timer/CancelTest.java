package com.example.yu.demo.controller.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Timer的其他函数
 * 1.cancel():作用：终止此计时器，丢弃所有当前已安排的任务
 * 2.purge():作用：从此计时器的任务队列中移除所有已取消的任务，返回值为从队列中移除的任务数
 */
public class CancelTest {
    public static void main(String[] args) throws InterruptedException {
        //创建Timer实例
        Timer timer = new Timer();
        //创建TimerTask实例
        MyTimerTask task1 = new MyTimerTask("task1");
        MyTimerTask task2 = new MyTimerTask("task2");
        //获取当前的执行时间并打印
        Date startTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("startTime:"+sdf.format(startTime));
        //task1首次执行是距离现在时间3s后执行，之后每隔2s执行一次
        //task2首次执行是距离现在时间1s后执行，之后每隔2s执行一次
        timer.schedule(task1,3000,2000);
        timer.schedule(task2,1000,2000);

        System.out.println("当前已经取消掉的任务数："+timer.purge());


        //休眠5s
        Thread.sleep(5000);
        //获取当前执行时间并打印
        Date cancelTime = new Date();
        System.out.println("canceltime："+sdf.format(cancelTime));
        //取消所有任务
        /*
            timer.cancel();
        *   System.out.println("TaskAll cancel");
        * */

        //注：不取消所有，只取消task1的任务
        task1.cancel();

        System.out.println("当前已经取消掉的任务数："+timer.purge());




    }
}
