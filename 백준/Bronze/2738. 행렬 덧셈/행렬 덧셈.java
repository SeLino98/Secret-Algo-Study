import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int rowSize = 2*N;
        int [][]A = new int[N][M];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            int iTmp = i%N;
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                A[iTmp][j] += tmp;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
