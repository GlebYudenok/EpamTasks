package by.javatr.yudenok.example4;

public class Demon extends Thread{
    public void run(){
        try {
            if(isDaemon()){
                System.out.println("Start Daemon thread.");
                Thread.sleep(10_000);
            }else
            {
                System.out.println("Start usual thread.");
            }
        }catch (InterruptedException e){
            System.err.println(e);
        }finally {
            if(!isDaemon())
                System.out.println("End usual thread.");
            else
                System.out.println("End Daemon thread.");
        }
    }
}
