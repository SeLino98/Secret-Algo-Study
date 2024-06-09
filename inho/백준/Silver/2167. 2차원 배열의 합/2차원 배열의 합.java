import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int[][] map ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int ySize = Integer.parseInt(st.nextToken())+1;
        int xSize = Integer.parseInt(st.nextToken())+1;
        map = new int[ySize][xSize];
        for (int i = 1; i <ySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <xSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//맵저장
        //갯수 할당
        int testSize = Integer.parseInt(br.readLine());
        for(int i = 0; i<testSize; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int result = calFunction(a,b,y,x);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
    static int calFunction(int a, int b, int y, int x){
        int sum = 0;
        for (int i = a; i <= y; i++) {
            for (int j = b; j <=x ; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}
