package zozo.company;

public class dick {

    public static void main(String[] args) {
	    Thread t1 = new Thread(new pussy("1"));
        Thread t2 = new Thread(new pussy("2"));
        Thread t3 = new Thread(new pussy("3"));
        t1.start();
        t2.start();
        t3.start();// write your code here
    }
}
