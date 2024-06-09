import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i],' ');

        }
        fillStar(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void fillStar(int x, int y, int n) {
        if (n == 1) {
            board[x][y] = '*';
            return;
        }

        int div = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {

                    continue;
                }
                fillStar(x + i * div, y + j * div, div);
            }
        }
    }
}
