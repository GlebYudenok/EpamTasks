package by.javatr.yudenok.example10;

public class Store {
    int counter = 0;
    int N = 5;

    synchronized int put(){
        if(counter <= N){
            counter++;
            System.out.println("Store have " + counter + " tovar(ov)");
            return 1;
        }
        return 0;
    }

    synchronized int get(){
        if(counter > 0){
            counter--;
            System.out.println("Store have " + counter + " tovar(ov)");
            return 1;
        }
        return 0;
    }

}
