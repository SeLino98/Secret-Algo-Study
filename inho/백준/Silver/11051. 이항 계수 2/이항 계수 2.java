import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static final int per = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        dp = new int[N+1][R+1];
        int sum = comBi(N,R);
        System.out.println(sum);
    }
    static int comBi(int n, int r){
        if(dp[n][r]>0){
            return dp[n][r];

        }
        if (n == r|| r == 0 ){
            return  dp[n][r] = 1;

        }
        return dp[n][r] = (comBi(n-1,r-1)+comBi(n-1,r))%per;
    }

}
