import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] correctPieces = {1, 1, 2, 2, 2, 8}; // 정답 배열
        int[] inputPieces = new int[6];

        for (int i = 0; i < 6; i++) {
            inputPieces[i] = sc.nextInt(); // 입력 받기
        }

        for (int i = 0; i < 6; i++) {
            System.out.print((correctPieces[i] - inputPieces[i]) + " ");
        }

        sc.close();
    }
}
