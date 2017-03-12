package s2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> arrayListStr = new ArrayList();
        String str = "";
        System.out.println("Введите элементы массива, после нажмите ctrl+D");
        if (scan.hasNext()) {
            str = scan.nextLine();
        }
        for (String z: str.split(" ")) {
            arrayListStr.add(z);
        }

        Collections.sort(arrayListStr, new MyComparator(""));

        for (int i = 0; i < arrayListStr.size(); i++) {
            System.out.println(arrayListStr.get(i));
        }
    }
}
