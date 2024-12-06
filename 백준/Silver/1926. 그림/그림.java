import java.io.*;
import java.util.*;
public class Main {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int rowSize,colSize ;
    static int countAnswer, answer = 0;
    static boolean [][]isVisited;
    static int [][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize][colSize];
        isVisited = new boolean[rowSize][colSize];
        //setting map
        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
            }
        }
        //BFS
        countAnswer = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int tmp = map[i][j];
                if (tmp==1){//Start BFS
                    countAnswer ++ ;
                    int subAnswer = BFS(i,j);
                    answer = Math.max(answer,subAnswer);
                }
            }
        }
        System.out.println(countAnswer);
        System.out.print(answer);
    }
    static int BFS(int y, int x){
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        isVisited[y][x] = true;
        while (!q.isEmpty()){
            int []xy = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = xy[0]+dy[i];
                int nextX = xy[1]+dx[i];
                if (nextY>=0&&nextX>=0&&nextY<rowSize&&nextX<colSize){
                    if (!isVisited[nextY][nextX]&&map[nextY][nextX]==1){
                        isVisited[nextY][nextX] = true;
                        map[nextY][nextX] = 0;
                        q.add(new int[]{nextY,nextX});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
