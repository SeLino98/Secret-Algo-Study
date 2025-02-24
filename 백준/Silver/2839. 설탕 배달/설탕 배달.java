import java.io.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] pack = {5, 3};

    public static void main(String[] args) throws IOException {
        int kg = Integer.parseInt(br.readLine());
        int fiveVal = kg / 5; // 5kg 최대 사용 개수
        int tmpValue;

        while (fiveVal >= 0) { // 5kg 봉지를 줄여가며 탐색
            tmpValue = kg - pack[0] * fiveVal;
            if (tmpValue % 3 == 0) {
                System.out.println(fiveVal + tmpValue / 3);
                return;
            }
            fiveVal--; // 5kg 봉지를 하나 줄여가며 확인
        }

        System.out.println(-1); // 정확히 나눌 수 없는 경우
    }
}
