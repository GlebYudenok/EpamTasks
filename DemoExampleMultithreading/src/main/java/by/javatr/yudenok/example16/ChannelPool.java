package by.javatr.yudenok.example16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChannelPool<T> {
    private final static int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> resource = new LinkedList<T>();
    public ChannelPool(Queue<T> res){
        this.resource.addAll(res);
    }

    public T getResource(long maxWaitMillis) throws Exception {
        try {
            if(semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)){
                T res = resource.poll();
                return res;
            }
        }catch (InterruptedException e){
            throw new Exception(e);
        }throw new Exception(":превышено время ожидания");
    }

    public void returnResource(T res){
        resource.add(res);
        semaphore.release();
    }
}
