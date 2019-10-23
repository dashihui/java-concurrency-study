package threadcoreknowledge.createthreads;

/**
 * 同时使用Runnable和Thread两种实现线程的方式
 * 运行结果 使用Thread方法来实现线程  因为thread重写了父类的方法
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用Runnable方法来实现线程");
            }
        }){
            @Override
            public void run() {
                System.out.println("使用Thread方法来实现线程");
            }
        }.start();
    }
}
