package by.javatr.yudenok.example1;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
