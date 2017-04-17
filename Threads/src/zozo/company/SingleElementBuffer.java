package zozo.company;

import com.oracle.jrockit.jfr.Producer;

import java.util.function.Consumer;

public class SingleElementBuffer {

    public static void main(String[] args) {
	SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Producer(1, 300, buffer)).start();
        new Thread(new Consumer(3, 600, buffer)).start();// write your code here
    }
}
