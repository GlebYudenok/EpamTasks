package by.javatr.yudenok.example13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int product = 0;
    private Lock lock;
    private Condition condition;

    Store(){
        lock = new ReentrantLock();
        condition = this.lock.newCondition();
    }

    public void put(){
        lock.lock();
        try {
            while (product >= 3) {
                condition.await();
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            condition.signal();
        }catch (InterruptedException e){
            System.err.println(e);
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try {
            while (product < 1){
                condition.await();
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);
            condition.signal();
        }catch (InterruptedException e){
            System.err.println(e);
        }finally {
            lock.unlock();
        }
    }
}
