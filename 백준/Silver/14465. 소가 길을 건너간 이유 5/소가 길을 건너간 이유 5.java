import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력 값 읽기
        int totalStopLight = Integer.parseInt(st.nextToken());
        int sizeSlide = Integer.parseInt(st.nextToken());
        int totalCrushedStopLight = Integer.parseInt(st.nextToken());

        // 신호등 배열 초기화 (1-based 인덱스 사용)
        boolean[] isCrushedStopLight = new boolean[totalStopLight + 1];
        for (int i = 0; i < totalCrushedStopLight; i++) {
            int crushedIndex = Integer.parseInt(br.readLine());
            isCrushedStopLight[crushedIndex] = true;
        }

        // 초기 슬라이딩 윈도우 내 깨진 신호등 개수 계산
        int countInitialCrushedStopLight = 0;
        for (int i = 1; i <= sizeSlide; i++) {
            if (isCrushedStopLight[i]) {
                countInitialCrushedStopLight++;
            }
        }

        // 최소값 초기화
        int minCrushedStopLight = countInitialCrushedStopLight;

        // 슬라이딩 윈도우 이동
        for (int start = 1, end = sizeSlide + 1; end <= totalStopLight; start++, end++) {
            if (isCrushedStopLight[start]) {
                countInitialCrushedStopLight--;
            }
            if (isCrushedStopLight[end]) {
                countInitialCrushedStopLight++;
            }
            minCrushedStopLight = Math.min(minCrushedStopLight, countInitialCrushedStopLight);
        }

        // 결과 출력
        System.out.print(minCrushedStopLight);
    }
}
