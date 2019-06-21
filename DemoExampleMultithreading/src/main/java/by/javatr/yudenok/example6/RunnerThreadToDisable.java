package by.javatr.yudenok.example6;

public class RunnerThreadToDisable {
    public static void main(String[] args) {
        System.out.println("Main thread started");
        ThreadToDisable t1 = new ThreadToDisable();
        Thread myThread = new Thread(t1, "name of ThreadToDisable");
        myThread.start();
        try {
            Thread.sleep(1100);
            Thread.currentThread().interrupt();
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Thread is interrupted");
        }
        System.out.println("Main thread is terminated");
    }
}
