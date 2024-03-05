import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][]dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];
        System.out.println(comBi(n-1,k-1));
    }
    static int comBi(int n , int k){
        if (dp[n][k]>0){
            return dp[n][k];
        }
        if(n==k||k==0){
            return dp[n][k] = 1;
        }else{
            return dp[n][k] = comBi(n-1,k-1)+comBi(n-1,k);
        }

    }
}
