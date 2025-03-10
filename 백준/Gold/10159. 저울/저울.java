import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int INF = 1_000_000;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0; // 자기 자신은 0
        }

        // 입력값 처리
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            map[heavy][light] = 1; // 무거운 것이 가벼운 것을 비교할 수 있음
        }
        // 플로이드
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] != INF && map[k][j] != INF) {
                        map[i][j] = 1; // 비교 가능 상태로 변경
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == INF && map[j][i] == INF) { // 비교 불가능한 경우
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}
