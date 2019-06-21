package by.javatr.yudenok.example6;

public class ThreadToDisable implements Runnable{

    public void disable(){
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        System.out.printf("Start %s thread\n", Thread.currentThread().getName());
        int counter = 1;
        while (true){
            System.out.println("Цикл " + counter++);
            try {
                if(Thread.currentThread().isInterrupted()){
                    break;
                }
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println("thread interrupted");
            }
        }
        System.out.printf("%s thread ends\n", Thread.currentThread().getName());
    }
}
