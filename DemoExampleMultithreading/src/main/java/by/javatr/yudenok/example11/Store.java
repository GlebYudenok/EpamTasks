package by.javatr.yudenok.example11;

public class Store {
    private int product = 0;

    public synchronized void put(){
        if(product >= 3){
            try {
                wait();
            }catch (InterruptedException e){
                System.err.println(e);
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void get(){
        while (product < 1){
           try {
               wait();
           }catch (InterruptedException e){
               System.err.println(e);
           }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

}
