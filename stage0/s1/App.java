package s1;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int arrayLength = 0;
        int max, min;
//        System.out.println("Введите кол-во элементов массива");
//
//        if (scan.hasNextInt()) {
//            arrayLength = scan.nextInt();
//        }
//        int[] dva = new int[arrayLength];
//
//        for (int i = 0; i < arrayLength; i++) {
//            System.out.println("Введите элемент массива №" + i + ":");
//            if (scan.hasNextInt()) {
//                dva[i] = scan.nextInt();
//            }
//        }

//        max = dva[0];
//        min = dva[0];
        int[] dva = new int[4];
        int i = 0;
        while (scan.hasNextInt()) {


        }

        for (int i = 1; i < arrayLength; i++) {
            if (max < dva[i]) {
                max = dva[i];
            }
            if (min > dva[i]){
                min = dva[i];
            }
        }

        for (int i = 0; i < arrayLength; i++) {
            System.out.print(dva[i] + " ");
        }
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
