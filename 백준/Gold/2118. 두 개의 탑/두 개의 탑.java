import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 백준 2118번
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        int listSum = 0;

        for (int i = 0; i < N; i++) { // 입력 받기
            int tmp = Integer.parseInt(br.readLine());
            list[i] = tmp;
            listSum += tmp;
        }

        if (N == 1) { // edge case 처리
            System.out.println(list[0]);
            return;
        }

        int lt = 0;
        int rt = 0;
        int sum = 0; // 초기값 0
        int answer = Integer.MIN_VALUE;

        while (lt < N) {
            if (sum <= listSum / 2 && rt < N) { // 오른쪽 포인터 이동
                sum += list[rt];
                rt++;
            } else { // 왼쪽 포인터 이동
                sum -= list[lt];
                lt++;
            }
            int tmp = Math.min(sum, listSum - sum);
            answer = Math.max(answer, tmp);
        }

        System.out.println(answer);
    }
}
