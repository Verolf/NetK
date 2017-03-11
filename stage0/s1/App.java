package s1;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer max, min;
        ArrayList<Integer> arrayListInt = new ArrayList();
        System.out.println("Введите элементы массива, после нажмите ctrl+D");
        while (scan.hasNextInt()) {
            arrayListInt.add(scan.nextInt());
        }

        max = arrayListInt.get(0);
        min = arrayListInt.get(0);
        for (int i = 1; i < arrayListInt.size(); i++) {
            if (max < arrayListInt.get(i)) {
                max = arrayListInt.get(i);
            }
            if (min > arrayListInt.get(i)){
                min = arrayListInt.get(i);
            }
        }

        for (int i = 0; i < arrayListInt.size(); i++) {
            System.out.print(arrayListInt.get(i) + " ");
        }
        System.out.println("");
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
