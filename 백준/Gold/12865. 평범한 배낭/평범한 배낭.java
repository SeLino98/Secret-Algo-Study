import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int countProduct = Integer.parseInt(st.nextToken());
        int limitWeight = Integer.parseInt(st.nextToken());
        int dp[][] = new int[countProduct+1][limitWeight+1];
        int weight[] = new int[countProduct+1];
        int value[] = new int[countProduct+1];
        int answer = 0;

        for (int i = 1; i <= countProduct; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weight[i] = w;
            value[i] = v;
        }

        //최대 가치 테이블을 만든다. i 축은 몇 개의 아이템을 선택한 것인지
        // w(x)축은 내가 담을 수 있는 최대 가방의 용량
        for (int i = 1; i <= countProduct; i++) {
            for (int w = 0; w <= limitWeight; w++) {
                if (weight[i]>w){
                    dp[i][w] = dp[i-1][w];
                }else{
                    dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-weight[i]]+value[i]);
                }
            }
        }
        answer = dp[countProduct][limitWeight];
        System.out.print(answer);
    }
}