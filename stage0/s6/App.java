package s6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Seva_ on 13.03.2017.
 */
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arrayListInt = new ArrayList();
        String str = "";
        int sum = 0;

        System.out.println("Введите элементы массива построчно, после нажмите ctrl+D");
        if (scan.hasNext()) {
            str = scan.nextLine();
        }
        for (String z: str.split(" ")) {
            arrayListInt.add(Integer.parseInt(z));
        }

        int length = arrayListInt.size();

        while (scan.hasNextInt()) {
            arrayListInt.add(scan.nextInt());
        }

        for (int i = 0, k = 0; i < length; i++) {
            sum = sum + arrayListInt.get(k);
            k = k + length + 1;
        }

        System.out.println(sum);

    }
}
