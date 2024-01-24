import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr [] = new int[10];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < 10; i++) {
            arr[i] = sc.nextInt();
            if (max<arr[i]){
                max = arr[i];
            }
        }
        for (int i = 1; i < 10; i++) {
            if (arr[i]==max){
                System.out.println(max);
                System.out.println(i);
            }
        }

    }
}