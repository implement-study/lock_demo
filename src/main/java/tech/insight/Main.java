package tech.insight;


import java.util.ArrayList;
import java.util.List;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] count = new int[]{1000};
        List<Thread> threads = new ArrayList<>();
        MyLock lock = new MyLock();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(() -> {
                for (int i1 = 0; i1 < 5; i1++) {
                    lock.lock();
                    count[0]--;
                }
                for (int i1 = 0; i1 < 5; i1++) {
                    lock.unlock();
                }
               
            }));
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(count[0]);
    }
    
}
