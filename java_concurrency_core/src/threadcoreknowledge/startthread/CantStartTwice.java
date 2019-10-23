package threadcoreknowledge.startthread;

/**
 * 演示不能两次调用start方法，否则会报错  IllegalThreadStateException   非法线程状态异常
 *  这里private volatile int threadStatus = 0;初始化的时候就是0
 *  if (threadStatus != 0)
    throw new IllegalThreadStateException();
 */
public class CantStartTwice {
    public static void main(String[]args){
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
