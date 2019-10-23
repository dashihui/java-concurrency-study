package threadcoreknowledge.createthreads;

/**
 * 使用Thread方法来实现线程
 */
public class ThreadStyle extends Thread{
    @Override
    public void run() {
        System.out.println("使用Thread方法来实现线程");
    }
    public static void main(String[]args){
        ThreadStyle threadStyle = new ThreadStyle();
        threadStyle.start();
    }
}
