package by.javatr.yudenok.example8;

public class Consumer extends Thread {
    Store store;
    int product = 0;

    Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run(){
        try {
            while (product < 5){
                product = product + store.get();
                System.out.println("Потребитель купил " + product + " товар(ов)");
                sleep(100);
            }
        }catch (InterruptedException e){
            System.err.println(e);
        }
    }
}
