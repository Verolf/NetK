package s1;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer max, min;
        ArrayList<Integer> arrayListInt = new ArrayList(8);
        System.out.println("Введите элементы массива, после нажмите ctrl+D");
        while (scan.hasNextInt()) {
            arrayListInt.add(scan.nextInt());
        }

        Integer[] arrayInt = arrayListInt.toArray(new Integer[arrayListInt.size()]);
        max = arrayInt[0];
        min = arrayInt[0];
        for (int i = 1; i < arrayInt.length; i++) {
            if (max < arrayInt[i]) {
                max = arrayInt[i];
            }
            if (min > arrayInt[i]){
                min = arrayInt[i];
            }
        }

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println("");
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
