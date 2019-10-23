package threadcoreknowledge.createthreads.wrongways;

public class LambdaDemo {
    public static void main(String[]args){
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
