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
        boolean flag = false;
        for (int i = 0; i < rowSize; i++) {
            if (i>=N) flag = true;
            st = new StringTokenizer(br.readLine());
            int iTmp = i%N;
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                A[iTmp][j] += tmp;
                if (flag) sb.append(A[iTmp][j]).append(" ");
            }
            if (flag) sb.append('\n');
        }
        System.out.print(sb);
    }
}
