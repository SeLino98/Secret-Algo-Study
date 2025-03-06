import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 버스 노선 개수
        int T = Integer.parseInt(st.nextToken()); // 도착 시간
        ArrayList<Integer> busTimes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 첫 버스 출발 시간
            int I = Integer.parseInt(st.nextToken()); // 간격
            int C = Integer.parseInt(st.nextToken()); // 운행 횟수

            for (int j = 0; j < C; j++) {
                int arrivalTime = S + I * j;
                if (arrivalTime >= T) {  // T보다 크거나 같은 경우만 리스트에 저장
                    busTimes.add(arrivalTime);
                }
            }
        }

        // 버스가 하나도 없는 경우
        if (busTimes.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(Collections.min(busTimes) - T);
        }
    }
}
