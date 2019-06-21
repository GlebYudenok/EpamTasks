package by.javatr.yudenok.example5;

public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        String nameT = getName();
        long timeout = 0;
        System.out.println(nameT + " thread started");
        try {
            switch (nameT){
                case "First":
                    timeout = 5_000;
                    break;
                case "Second":
                    timeout = 1_000;
                    break;
            }
            Thread.sleep(timeout);
            System.out.println("Ends " + nameT + " thread");
        }catch (InterruptedException e){
            System.err.println(e);
        }
    }
}
