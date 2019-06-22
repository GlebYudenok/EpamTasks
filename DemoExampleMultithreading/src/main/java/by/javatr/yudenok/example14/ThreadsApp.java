package by.javatr.yudenok.example14;

import java.util.concurrent.Semaphore;

public class ThreadsApp {
    public static void main(String[] args) {
        CommonResource res = new CommonResource();
        Semaphore semaphore = new Semaphore(1);
        new Thread(new CountThread(res, semaphore, "CountThread 1")).start();
        new Thread(new CountThread(res, semaphore, "CountThread 2")).start();
        new Thread(new CountThread(res, semaphore, "CountThread 3")).start();
    }
}
