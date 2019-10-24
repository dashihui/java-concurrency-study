package threadcoreknowledge.sixstates;

/**
 * 展示线程的NEW、RUNNABLE、Terminated状态。即使是正在运行，也是Runnable状态，而不是Running。
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
    
    public static void main(String[]args){
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW的状态
        System.out.println(thread.getState());
        thread.start();
        //线程使用start方法之后里面打印线程的状态
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);//这里的sleep(10)是为了看他是不是会有Running状态打印出来

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出RUNNABLE的状态，即使是正在运行，也是RUNNABLE，而不是RUNNING
        System.out.println(thread.getState());
        try {
            Thread.sleep(1000);//这里是主线程等待，等待完成之后那么当前子线程的状态肯定是TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出TERMINATED状态
        System.out.println(thread.getState());

    }
}
