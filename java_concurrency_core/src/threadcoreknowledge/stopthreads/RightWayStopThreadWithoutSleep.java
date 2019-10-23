package threadcoreknowledge.stopthreads;

/**
 * run方法内没有sleep或wait方法时，停止线程
 *
 */
public class RightWayStopThreadWithoutSleep implements Runnable{
    public static void main(String[]args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);//主线程睡2秒
        thread.interrupt();//可以理解为把状态设置一下
    }

    @Override
    public void run() {
        int num = 0;
        while(!Thread.currentThread().interrupted()&&num<=Integer.MAX_VALUE){
            if(num%10000==0){
                System.out.println(num+" 是10000的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束了");
    }
}
