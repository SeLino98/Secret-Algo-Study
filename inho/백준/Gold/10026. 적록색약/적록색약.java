import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] board;
    static int[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        board = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int normalCount = 0;
        int blindCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 || visited[i][j] == 2) {//2은 색약시력분들의 탐색이 완료된 것
                    BFS(i, j, board[i][j], false);
                    normalCount++;
                }
                if (visited[i][j] == 0 || visited[i][j] == 1) { //1은 정상시력분들은 탐색이 완료된 것
                    BFS(i, j, board[i][j], true);
                    blindCount++;
                }
            }
        }
        sb.append(normalCount).append(" ").append(blindCount);
        System.out.println(sb);
    }

    static boolean shouldVisit(int x, int y, char color, boolean isColorBlind) {
        if (isColorBlind) {//색맹일 때
            if (color == 'B' && board[x][y] == 'B') {
                return true;
            } else return (color == 'R' || color == 'G') && (board[x][y] == 'R' || board[x][y] == 'G');
        } else { //아닐 땐 색만 같은지 보면됨.
            return board[x][y] == color;
        }
    }

    static void BFS(int x, int y, char color, boolean isColorBlind) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int curX = point[0];
            int curY = point[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    int visitValue = isColorBlind ? 2 : 1;
                    if (visited[nextX][nextY] == 0 || visited[nextX][nextY] + visitValue == 3) {
                        if (shouldVisit(nextX, nextY, color, isColorBlind)) {
                            visited[nextX][nextY] += visitValue;
                            q.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
    }
}