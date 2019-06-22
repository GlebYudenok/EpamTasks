package by.javatr.yudenok.example16;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<AudioChannel> list = new LinkedList<AudioChannel>();
                list.add(new AudioChannel(771));
                list.add(new AudioChannel(883));
                list.add(new AudioChannel(550));
                list.add(new AudioChannel(337));
                list.add(new AudioChannel(442));

        ChannelPool<AudioChannel> pool = new ChannelPool<>(list);
        for (int i = 0; i < 20; i++) {
            new Client(pool).start();
        }
    }
}
