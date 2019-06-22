package by.javatr.yudenok.example10;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        producer.start();
        consumer.start();
    }
}
