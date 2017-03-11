package s2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Seva_ on 11.03.2017.
 */
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        ArrayList<String> arrayListInt = new ArrayList(8);
        String str = "";
        System.out.println("Введите элементы массива, после нажмите ctrl+D");
        if (scan.hasNextLine()) {
            str = scan.nextLine();
        }

//        String[] arrayString = arrayListInt.toArray(new String[arrayListInt.size()]);

//        for (int i = 0; i < str.length; i++) {
//            System.out.print( str[i] + " ");
//        }

        System.out.println(str);

    }
}
