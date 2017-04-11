package OOP_Task.complexNumber;

import java.util.Arrays;

/**
 * Created by Seva_ on 04.04.2017.
 */
public class App {
    public static void main(String... args) {
        ComplexNumber co = new ComplexNumberImpl();
        co.set(0, 2);
        System.out.println(co.toString());
    }
}
