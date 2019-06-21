package by.javatr.yudenok.example5;

public class RunnerJoin {
    public static void main(String[] args) {
        JoinThread t1 = new JoinThread("First");
        JoinThread t2 = new JoinThread("Second");
        t1.start();
        t2.start();
        try {
            t1.join();
        }catch (InterruptedException e){
            System.err.println(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
