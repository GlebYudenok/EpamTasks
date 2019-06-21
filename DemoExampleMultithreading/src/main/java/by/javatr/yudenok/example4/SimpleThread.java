package by.javatr.yudenok.example4;

import java.util.Date;

public class SimpleThread {
    public static void main(String[] args) {
        Demon usualThread = new Demon();
        Demon daemonThread = new Demon();
        daemonThread.setDaemon(true);

        usualThread.start();
        daemonThread.start();

        System.out.println("Last operator main.");
    }
}
