package threadcoreknowledge.startthread;

/**
 * 对比start和run两种启动线程的方式
 * run方法只会调用当前的线程来执行，并不会创建一个新的线程执行
 * thread.start(); 该行代码相当于是启动线程，
 * thread.run(); 该行代码相当于是使用thread这个类中的run方法而已.
 * 1)线程的实现有两种方式，一是继承Thread类，二是实现Runnable接口，但不管怎样，当我们new了Thread实例后，线程就进入了初始状态；
 * 2)当该对象调用了start()方法，就进入可运行状态；
 *
 */
public class StartAndRunMethod {
    public static void main(String[]args){
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行 Thread中重新run方法");
            }
        };
        thread.run();
        //thread.start();
    }
}
