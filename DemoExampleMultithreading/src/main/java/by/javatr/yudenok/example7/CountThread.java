package by.javatr.yudenok.example7;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class CountThread implements Runnable {

    CommonResource res;

    CountThread(CommonResource res){
        this.res = res;
    }

    @Override
    public void run() {

        synchronized(res) {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
