package by.javatr.yudenok.example8;

import java.io.IOException;

public class SynchroRun {
    public static void main(String[] args) {
        Resource res = null;
        try {
            res = new Resource("D:\\Epam\\EpamTasks\\" +
                    "DemoExampleMultithreading\\src\\main\\" +
                    "java\\by\\javatr\\yudenok\\example8\\file");
            SyncThread first = new SyncThread("First", res);
            SyncThread second = new SyncThread("Second", res);
            first.start();
            second.start();
            first.join();
            second.join();
        }catch (IOException | InterruptedException e){
            System.err.println(e);
        }finally {
            res.close();
        }
        System.out.println("Завершение главного потока");
    }
}
