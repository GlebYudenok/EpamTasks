package by.javatr.yudenok.example3;

public class PriorityRunner {
    public static void main(String[] args) {
        Thread min = new Thread(new PriorThread("Min"));
        Thread norm = new Thread(new PriorThread("Norm"));
        Thread max = new Thread(new PriorThread("Max"));
        min.setPriority(Thread.MIN_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        min.start();
        norm.start();
        max.start();
    }
}
