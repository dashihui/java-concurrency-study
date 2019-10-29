package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 *  3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify, notifyAll。 start先执行不代表线程先启动。
 */
public class WaitNotifyAll implements Runnable{
    private static final Object object = new Object();

    public static void main(String[]args) throws InterruptedException {
        WaitNotifyAll waitNotifyAll = new WaitNotifyAll();
        Thread thread1 = new Thread(waitNotifyAll);
        Thread thread2 = new Thread(waitNotifyAll);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    object.notifyAll();//唤醒所有线程
                    System.out.println("所有线程被唤醒");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(500);
        thread3.start();

    }
    @Override
    public void run() {
        synchronized(object){
            System.out.println(Thread.currentThread().getName()+" 得到锁");
            try {
                System.out.println(Thread.currentThread().getName()+" 开始等待");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 线程执行完毕");
        }
    }
}
