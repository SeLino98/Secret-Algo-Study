import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] schedule;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N까지만 일 함
        schedule = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 상담 하는데 걸리는 일 수
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 돈
        }

        result = 0;
        // 0일 부터 시작함
        dfs(0, 0);
        System.out.println(result);
    }
    static void dfs(int idx, int pay){


        if (idx>=N){
            result = Math.max(result,pay);
            return;
        }
        if (idx+schedule[idx][0]<=N){//상담을 계속할 수 있는 경우
            dfs(idx+schedule[idx][0],pay+schedule[idx][1]);
        }else{//상담을 계속할 수 없는 경우 시간이 오바되는 경우
            dfs(idx+schedule[idx][0],pay);
        }
        dfs(idx+1,pay);
    }
}