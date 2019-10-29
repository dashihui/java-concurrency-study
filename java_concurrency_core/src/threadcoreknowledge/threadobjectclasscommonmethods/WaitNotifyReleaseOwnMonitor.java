package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 证明wait只释放当前的那把锁
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[]args) throws InterruptedException {
        //让A线程获取resourceA、resourceB的锁 再释放resourceA的锁
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("线程A获取到了  resourceA的锁");
                    synchronized (resourceB){
                        System.out.println("线程A获取到了  resourceB的锁");
                        try {
                            System.out.println("线程A释放了 resourceA的锁");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });


        //线程B来执行获取resourceA、resourceB的锁 并且执行
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA){
                    System.out.println("线程B获取到了resourceA的锁");
                    System.out.println("线程B尝试获取resourceA的锁=======>   然而并不能获取到 -_-!  陷入等待中。。。。。。");
                    synchronized (resourceB){
                        System.out.println("线程B获取到resourceB的锁");//没有获取到
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
