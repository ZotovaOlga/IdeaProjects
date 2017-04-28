package zozo.company;
import java.util.*;
/**
 * Created by Измерение on 20.04.2017.
 */
public class pussy implements Runnable {

    int time;
    String name;
    Random r = new Random();
    public pussy(String name){
        this.name = name;
        time = r.nextInt(999);

    }

    @Override
    public void run() {
        System.out.printf("Поток %s спит %d \n", name, time);
        try{
            Thread.sleep(time);
        } catch(Exception e){}
        System.out.printf("Поток %s проснулся и закончился \n", name, time);

    }
}
