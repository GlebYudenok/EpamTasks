package by.javatr.yudenok.example9;

public class TwoThreads {
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        final StringBuilder s = new StringBuilder();
        Thread t = new Thread(){
            public void run(){
                synchronized (s){
                    do{
                        s.append("A");
                        System.out.println(s);
                        try {
                            Thread.sleep(100);
                        }catch (InterruptedException e){
                            System.err.println(e);
                        }
                    }while (TwoThreads.counter++ < 2);
                }
            }
        };

        t.start();

        new Thread(){
            public void run(){
                synchronized (s){
                    while (TwoThreads.counter++ < 6){
                        s.append("B");
                        System.out.println(s);
                    }
                }
            }
        }.start();
    }
}
