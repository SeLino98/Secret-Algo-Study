import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int mapSize;
    static boolean[][] isVisitMap;
    static int[][] map;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean canAnswer = false;

    public static void main(String[] args) throws IOException {
        mapSize = Integer.parseInt(br.readLine());
        isVisitMap = new boolean[mapSize][mapSize];
        map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);

        if (canAnswer) {
            System.out.print("HaruHaru");
        } else {
            System.out.print("Hing");
        }
    }

    static void DFS(int y, int x) {
        // 도착 조건
        if (map[y][x] == -1) {
            canAnswer = true;
            return;
        }

        // 방문 처리
        isVisitMap[y][x] = true;

        // 점프 크기
        int jump = map[y][x];

        // 다음 위치 탐색
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * jump;
            int ny = y + dy[i] * jump;

            // 경계 체크 및 방문 여부 확인
            if (nx >= 0 && ny >= 0 && nx < mapSize && ny < mapSize && !isVisitMap[ny][nx]) {
                DFS(ny, nx);
            }
        }

        // 백트래킹을 위해 방문 해제
        isVisitMap[y][x] = false;
    }
}
