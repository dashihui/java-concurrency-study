package threadcoreknowledge.stopthreads;

/**
 * 如果while里面放try/catch，会导致中断失效
 */
public class CantInterrupt implements Runnable{
    @Override
    public void run() {
        int num = 0;
        while(num<=10000&&!Thread.currentThread().isInterrupted()){
            if(num%100==0){
                System.out.println(num+"是100的倍数");
            }
            num++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new CantInterrupt());
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
