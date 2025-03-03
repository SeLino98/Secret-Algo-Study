import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            int kindOfCoin = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int [] coin = new int[kindOfCoin];
            for (int k = 0; k < kindOfCoin; k++) {
                coin[k] = Integer.parseInt(st.nextToken());
            }
            int findValue = Integer.parseInt(br.readLine());
            int [] dp = new int[findValue+1];
            dp[0] = 1;
            for (int i = 0; i < kindOfCoin; i++) {
                for (int j = coin[i]; j <= findValue; j++) {
                    dp[j] += dp[j-coin[i]];
                }
            }
            int answer = dp[findValue];
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}