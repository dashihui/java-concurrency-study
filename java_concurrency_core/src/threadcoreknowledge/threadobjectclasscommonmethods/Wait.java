package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 展示wait和notify的基本用法 1. 研究代码执行顺序 2. 证明wait释放锁
 */
public class Wait {
    public static Object object = new Object();
    //让Thread1先拿到锁
    static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"  开始执行了");
            synchronized (object){
                try {
                    object.wait(3000);//释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"  获取到了锁");
        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                object.notify();//唤醒
                System.out.println("线程" + Thread.currentThread().getName() + "调用了notify()");
            }
        }
    }
    
    public static void main(String[]args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }
}
