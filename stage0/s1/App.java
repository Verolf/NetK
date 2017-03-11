package s1;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = 0;
        int max, min;
        System.out.println("Введите кол-во элементов массива");

        if (scan.hasNextInt()) {
            k = scan.nextInt();
        }
        int[] dva = new int[k];

        for (int i = 0; i < k; i++) {
            System.out.println("Введите элемент массива №" + i + ":");
            if (scan.hasNextInt()) {
                dva[i] = scan.nextInt();
            }
        }

        max = dva[0];
        min = dva[0];

        for (int i = 1; i < k; i++) {
            if (max < dva[i]) {
                max = dva[i];
            }
            if (min > dva[i]){
                min = dva[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(dva[i] + " ");
        }
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
