package by.javatr.yudenok.example16;

public class AudioChannel {
    private int chanelId;
    public AudioChannel(int id){
        super();
        this.chanelId = id;
    }

    public int getChanelId() {
        return chanelId;
    }

    public void setChanelId(int chanelId) {
        this.chanelId = chanelId;
    }

    public void using(){
        try {
            Thread.sleep(new java.util.Random().nextInt(500));
        }catch (InterruptedException e){
            System.err.println(e);
        }
    }
}
