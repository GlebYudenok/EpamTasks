package by.javatr.yudenok.example2;

public class RunnablePerson extends Person implements Runnable {

    public RunnablePerson(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++)
        System.out.println("Hello i'm " + getName());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnablePerson("John"));
        Thread thread2 = new Thread(new RunnablePerson("George"));
        Thread thread3 = new Thread(new RunnablePerson("Alexey"));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
