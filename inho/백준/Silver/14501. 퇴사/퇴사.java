import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int[][] schedule = new int[days][2];
        int[] dp = new int[days];
        StringTokenizer st ;
        for (int i = 0; i < days; i++) {
            //0일부터 받는다. 즉 출력할 땐 days-1로 출력한다.
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());//d
            schedule[i][1] = Integer.parseInt(st.nextToken());//p
        }
        for (int i = 0; i < days; i++) {
            if (i + schedule[i][0] <= days) { // 7일을 넘어가지 않았다면
                if (i >0){
                    int value = 0 ;
                    for (int j = 0; j < i; j++) {
                        value = Math.max(value,dp[j]);
                    }
                    int sum = value+schedule[i][1];//전에 값들 중 최대 값과 현재 위치에서 pay 값을 더한다.
                    dp[i + schedule[i][0] - 1] = Math.max(dp[i + schedule[i][0] - 1], sum);
                }else{
                    dp[i + schedule[i][0] - 1] = Math.max(dp[i + schedule[i][0] - 1], schedule[i][1]);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < days; i++) {
            answer = Math.max(answer,dp[i]);
        }
        System.out.print(answer);
    }
}
