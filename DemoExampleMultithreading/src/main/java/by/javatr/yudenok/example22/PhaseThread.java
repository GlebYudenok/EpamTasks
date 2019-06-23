package by.javatr.yudenok.example22;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable {

    private Phaser phaser;
    private String name;

    public PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister();
    }
}
