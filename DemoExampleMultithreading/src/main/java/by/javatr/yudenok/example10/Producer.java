package by.javatr.yudenok.example10;

public class Producer extends Thread {
    Store store;
    int product = 5;

    Producer(Store store){
        this.store = store;
    }

    @Override
    public void run(){
        try {
            while (product > 0){
                product = product - store.put();
                System.out.println("Производиетелю осталось произвести " + product + " товар(ов)");
                sleep(100);
            }
        }catch (InterruptedException e)
        {
            System.err.println(e);
        }
    }
}
