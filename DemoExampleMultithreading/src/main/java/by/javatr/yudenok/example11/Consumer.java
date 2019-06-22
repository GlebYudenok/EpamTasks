package by.javatr.yudenok.example11;

public class Consumer extends Thread {
    Store store;

    Consumer(Store store){
        this.store = store;
    }

    @Override
    public void run(){
        for(int i = 1; i < 6; i++){
            store.get();
        }
    }
}
