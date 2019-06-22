package by.javatr.yudenok.example15;

import javafx.scene.control.Tab;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i = 0; i < 9; i++){
            new Philosopher(i, semaphore).start();
        }
    }
}
