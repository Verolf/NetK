package OOP_Task.arrayVector;

/**
 * Created by Seva_ on 01.04.2017.
 */
public class App {

    public static void main(String args[]) {
    try {
        StringBuffer b1 = new StringBuffer("HI!");
        StringBuffer b2 = b1;
        b1.setCharAt(1, 'A');
        b1 = null;
        System.out.println(b2);
    } catch (NullPointerException e) {
        System.out.println("Null PE");
    }
    }

}
