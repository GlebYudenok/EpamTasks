package by.javatr.yudenok.example12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {

    CommonResource res;
    Lock lock = null;

    CountThread(CommonResource res, Lock lock){
        this.res = res;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        res.x = 1;
        for (int i = 1; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
            res.x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
        }
    }
}
