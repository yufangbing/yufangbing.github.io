package com.example.yu.demo.controller.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;


public class MyTimer {
    public static void main(String[] args) {
        //1.创建一个timer实例
        Timer timer = new Timer();
        //2.创建一个MyTimerTask实例
        MyTimerTask myTimerTask = new MyTimerTask("No.1");

        /**
         * 3.通过timer定时定频率调用MyTimerTask的业务逻辑
         * 即第一次执行是在当前的2s之后，之后每隔1s钟执行一次
         */
        timer.schedule(myTimerTask,2000L,1000L);


        //获取当前时间，并设置当前时间3s后的时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("time:"+sdf.format(calendar.getTime()));
        calendar.add(Calendar.SECOND,3);

        //-------------schedule的4种用法-----------
        /**
         *  1.schedule(task,time): task——所要安排的任务  time——执行任务的时间
         *  *  作用：在时间等于或超过time的时候执行且仅执行一次task
         */
        /*myTimerTask.setName("schedule1");
        timer.schedule(myTimerTask,calendar.getTime());

        //scheduledExecutionTime 打印最近一次计划时间，返回值long类型
        System.out.println(myTimerTask.scheduledExecutionTime());
        */


        /**
         *  2.schedule(task,time,period): task——所要安排的任务  time——首次执行任务的时间   period——执行一次task的时间间隔，单位毫秒
         *  *  作用：时间等于或超过time的时候首次执行task，之后每隔period毫秒重复执行一次task
         */
        /*myTimerTask.setName("schedule2");
        timer.schedule(myTimerTask,calendar.getTime(),2000);*/

        /**
         *  3.schedule(task,delay): task——所要安排的任务  delay——执行任务前的延时时间，单位毫秒
         *  *  作用：等待delay毫秒后执行且仅执行一次task
         */
       /* myTimerTask.setName("schedule3");
        timer.schedule(myTimerTask,1000);*/

        /**
         *  4.schedule(task,delay,period): task——所要安排的任务  delay——执行任务前的延时时间，单位毫秒   period——执行一次task的时间间隔，单位毫秒
         *  *  作用：等待delay毫秒后首次执行task，之后每隔period毫秒重复执行一次task
         */
        /*myTimerTask.setName("schedule4");
        timer.schedule(myTimerTask,3000,2000);*/


        /**
         *  5.scheduleAtFixedRate(task,time,period): task——所要安排的任务  time——首次执行任务的时间   period——执行一次task的时间间隔，单位毫秒
         *  *  作用：时间等于或超过time的时候首次执行task，之后每隔period毫秒重复执行一次task
         */
        /*myTimerTask.setName("scheduleAtFixedRate1");
        timer.scheduleAtFixedRate(myTimerTask,calendar.getTime(),2000);*/


        /**
         *  6.scheduleAtFixedRate(task,delay,period): task——所要安排的任务  delay——执行任务前的延时时间，单位毫秒   period——执行一次task的时间间隔，单位毫秒
         *  *  作用：等待delay毫秒后首次执行task，之后每隔period毫秒重复执行一次task
         */
        /*myTimerTask.setName("scheduleAtFixedRate2");
        timer.scheduleAtFixedRate(myTimerTask,3000,2000);*/


        /**
         * schedule和scheduleAtFixedRate的区别的2种情况
         * 1.首次计划执行的时间早于当前的时间
         * 2.任务执行所需要时间超出任务的执行周期间隔
         *
         *
         * （1）如果第一次执行时间被delay了：
         * schedule方法：
         *      随后的执行时间按照上一次实际执行完成的时间点进行计算
         * scheduleAtFixedRate方法：
         *      随后的执行时间按照上一次开始的时间点进行计算，并且为了赶上进度会多次执行任务，
         *      因此TimerTask中的执行体需要考虑同步
         *
         *
         * （2）.任务执行所需要时间超出任务的执行周期间隔
         * schedule方法：
         *       下一次执行时间相对于上一次实际执行完成的时间点，因此执行时间会不断延后
         * scheduleAtFixedRate方法：
         *       下一次执行时间相对于上一次开始的时间点，因此执行时间一般不会延后，存在并发性
         *
         */


        /**
         * 1.管理并发任务的缺陷：
         *      Timer有且仅有一个线程去执行定时任务，如果存在多个任务，且任务时间过长，会导致执行效果与预期不符
         * 2.当任务抛出异常时的缺陷
         *      如果TimerTask抛出RuntimeException，Timer会停止所有任务的运行
         * 注：使用禁区：
         *      对时效性要求较高的多任务并发作业
         *      对复杂任务的调度
         */





    }
}
