import java.io.*;
import java.util.*;
public class Main {
    static int rowSize,colSize, testCase ;
    static int [][][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize+1][colSize+1][3];//0 정글, 1 바다, 2 얼음
        testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= rowSize ; i++) { //맵 저장
            char [] tmpCharList = br.readLine().toCharArray();
            for (int j = 0; j < tmpCharList.length; j++) {
                for (int k = 0; k < 3; k++) {
                    map[i][j+1][k] = map[i][j][k] + map[i-1][j+1][k] - map[i-1][j][k];
                }
                switch (tmpCharList[j]){
                    case 'J' :
                        map[i][j+1][0] ++;
                        break;//row마다 누적합시키기.
                    case 'O' :
                        map[i][j+1][1] ++;
                        break;
                    case 'I' :
                        map[i][j+1][2] ++;
                        break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int fy = Integer.parseInt(st.nextToken());
            int fx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            for (int k = 0; k < 3; k++) {
                int answer = totalSum(k,fy,fx,sx,sy);
                sb.append(answer).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int totalSum(int k , int fy, int fx, int sx, int sy){
        return map[sy][sx][k] - map[fy-1][sx][k] - map[sy][fx-1][k] + map[fy-1][fx-1][k];
    }
}
