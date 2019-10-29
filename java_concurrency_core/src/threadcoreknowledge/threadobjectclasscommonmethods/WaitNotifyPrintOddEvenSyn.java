package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 两个线程交替打印0~100的奇偶数，用synchronized关键字实现   线程一打印奇数   线程二打印偶数
 */
public class WaitNotifyPrintOddEvenSyn {
    private static int count;

    private static final Object lock = new Object();

    //新建2个线程
    //1个只处理偶数，第二个只处理奇数（用位运算）
    //用synchronized来通信
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if (count % 2 == 1) {//说明是奇数
                            System.out.println("当前线程A打印 " + count + "是奇数");
                            count++;
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if (count % 2 == 0) {//说明是奇数
                            System.out.println("当前线程B打印 " + count + "是偶数");
                            count++;
                        }
                    }
                }
            }
        }).start();
    }
}
