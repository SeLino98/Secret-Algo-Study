import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while (true){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L == 0) break;
            int mox = V/P;
            int nam = V%P;
            if (nam>L){
                nam = L;
            }
            int answer = mox*L + nam;
            sb.append("Case ").append(testCase++).append(": ").append(answer).append('\n');
        }
        System.out.print(sb);
    }
}