package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;

/**
 * 用wait/notify来实现生产者消费者模式
 */
public class ProducerConsumerModel {
    public static void main(String[]args){
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Concumer concumer = new Concumer(eventStorage);
        new Thread(producer).start();
        new Thread(concumer).start();
    }
}
//消费者
class Concumer implements Runnable{
    private EventStorage storage;

    public Concumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            storage.take();
        }
    }
}
//生产者
class Producer implements Runnable{
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            storage.put();
        }
    }
}
//仓库
class EventStorage{
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void put(){
        while(maxSize==storage.size()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品。");
        notify();
    }
    public synchronized void take(){
        while(storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() + "，现在仓库还剩下" + storage.size());
        notify();
    }
}
