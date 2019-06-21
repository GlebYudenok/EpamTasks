package by.javatr.yudenok.example3;

public class PriorThread extends Thread {
    public PriorThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        for(int i = 0; i < 50; i++){
            System.out.println(getName() + " " + i);
            try {
                Thread.sleep(0);
            }catch (InterruptedException e){
                System.err.println(e);
            }
        }
    }
}
