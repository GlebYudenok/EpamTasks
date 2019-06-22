package by.javatr.yudenok.example14;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable {

    private CommonResource res;
    private Semaphore semaphore;
    private String name;

    CountThread(CommonResource res, Semaphore semaphore, String name){
        this.semaphore = semaphore;
        this.name = name;
        this.res = res;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ожидает разрешение");
            semaphore.acquire();
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", name, res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e){
            System.err.println(e);
        }
        semaphore.release();
    }
}
