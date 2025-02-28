import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static int friendCount;
    static int testCase ;
    static int [][]friendMap;
    final static int MAP_MAX_VALUE = 200;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        friendCount = Integer.parseInt(st.nextToken());
        testCase = Integer.parseInt(st.nextToken());
        friendMap = new int[friendCount][friendCount];
        //맵 초기화
        for (int i = 0; i < friendCount; i++) {
            Arrays.fill(friendMap[i],MAP_MAX_VALUE);
        }
        //맵 입력
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;
            friendMap[f][s] = 1;
            friendMap[s][f] = 1;
        }
        //플로이드 워셜
        for(int k = 0; k<friendCount; k++){
            for (int i = 0; i < friendCount; i++) {
                for (int j = 0; j < friendCount; j++) {
                    friendMap[i][j] = Math.min(friendMap[i][j],friendMap[i][k]+friendMap[k][j]);
                }
            }
        }
        //값 계산
        int friendMinPersonNum = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < friendCount; i++) {
            int rowCount = 0;
            for (int j = 0; j < friendCount; j++) {
                if (i==j) continue;
                rowCount+=friendMap[i][j];
            }
            if (friendMinPersonNum>rowCount){
                friendMinPersonNum = rowCount;
                answer = i;
            }
        }
        System.out.print(answer+1);
    }
}