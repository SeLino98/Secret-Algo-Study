import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int mapSize, cityRouteSize;
    static int [][]map ;
    static final int maxValue = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws IOException {
        mapSize = Integer.parseInt(br.readLine());
        cityRouteSize = Integer.parseInt(br.readLine());
        map = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {//최댓값 갱신
            Arrays.fill(map[i],maxValue);
        }
        StringTokenizer st ;
        for (int i = 0; i < cityRouteSize; i++) {//맵 저장
            st = new StringTokenizer(br.readLine());
            int startPos = Integer.parseInt(st.nextToken())-1;
            int endPos = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            map[startPos][endPos] = Math.min(map[startPos][endPos], cost);
        }
        //플로이드 워셜 구현
        for (int k = 0; k < mapSize; k++) {
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (map[i][k]==maxValue||map[k][j]==maxValue) continue;
                    if(i==j) continue;
                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == maxValue){
                    sb.append(0).append(" ");
                }else{
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
