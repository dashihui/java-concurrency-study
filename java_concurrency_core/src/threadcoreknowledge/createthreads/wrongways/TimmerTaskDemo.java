package threadcoreknowledge.createthreads.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器创建线程
 *
 * 定时器顺便学习
 * 延迟delay毫秒后每隔period毫秒执行一次
 */
public class TimmerTaskDemo {
    public static void main(String[]args){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行");
            }
        },10000,1000);
    }
}
