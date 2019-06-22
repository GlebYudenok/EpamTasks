package by.javatr.yudenok.example16;

public class Client extends Thread{
    private boolean reading = false;
    private ChannelPool<AudioChannel> pool;
    public Client(ChannelPool<AudioChannel> pool){
        this.pool = pool;
    }

    @Override
    public void run(){
        AudioChannel channel = null;
        try {
            channel = pool.getResource(500);
            reading = true;
            System.out.println("Channel client #" + getId() + " took channel #" + channel.getChanelId());
            channel.using();
        }catch (Exception e){
            System.err.println(e);
        }finally {
            if(channel != null){
                reading = false;
                System.out.println("Channel client #" + getId() + " : " + channel.getChanelId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }
}
