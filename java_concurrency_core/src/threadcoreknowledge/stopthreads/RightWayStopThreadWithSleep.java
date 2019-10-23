package threadcoreknowledge.stopthreads;

/**
 *  带有sleep的中断线程的写法
 */
public class RightWayStopThreadWithSleep {
    public static void main(String[]args) throws InterruptedException {
        Runnable runnable = ()->{
            try {
                int num =0;
                while(num<=300&&!Thread.currentThread().isInterrupted()){
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();//这里要拿实例调用interrupt方法来打断睡眠
        //Thread.currentThread().interrupted();

    }
}