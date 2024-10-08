import java.io.*;
import java.util.*;
public class Main {
    static int rowSize,colSize;
    static int [] dx ={-1,0,1,0,-1,1,-1,1};
    static int [] dy ={0,1,0,-1,1,1,-1,-1};
    static int [][]map ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize][colSize];
         for (int i = 0; i < rowSize ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
            }
        }
        int answer = 0;
        for (int i = 0; i < rowSize ; i++) {
            for (int j = 0; j < colSize; j++) {
                if(map[i][j] == 1){
                    BFS(i,j);
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
    static void BFS(int y, int x){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        while (!q.isEmpty()){
            int []posXY = q.poll();
            int posX = posXY[1];
            int posY = posXY[0];
            for (int i = 0; i < 8; i++) {
                int nX = posX + dx[i];
                int nY = posY + dy[i];
                if (nY>=0&&nX>=0&&nY<rowSize&&nX<colSize){
                    if (map[nY][nX]==1){
                        q.add(new int[]{nY,nX});
                        map[nY][nX] = 2;
                    }
                }
            }
        }
    }

}
