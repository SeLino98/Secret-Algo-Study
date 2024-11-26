import java.io.*;
import java.util.*;
public class Main {
    static int rowSize,colSize,trashCount = 0;
    static boolean [][] doVisited ;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        trashCount = Integer.parseInt(st.nextToken());
        doVisited = new boolean[rowSize+1][colSize+1];
        for (int i = 0; i < trashCount; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpRow = Integer.parseInt(st.nextToken());
            int tmpCol = Integer.parseInt(st.nextToken());
            doVisited[tmpRow][tmpCol] = true;
        }
        int answer = 0;
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                if (doVisited[i][j]){
                    int tmpCount = BFS(i,j);
                    answer = Math.max(tmpCount,answer);
                }
            }
        }
        System.out.print(answer);
    }
    static int BFS(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        doVisited[y][x] = false;
        int maxCount = 1;
        while (!q.isEmpty()){
            int [] curPos = q.poll();
            int curY = curPos[0];
            int curX = curPos[1];
            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                if (nextY>0&&nextX>0&&nextX<=colSize&&nextY<=rowSize){
                    if (doVisited[nextY][nextX]){
                        q.add(new int[]{nextY,nextX});
                        doVisited[nextY][nextX] = false;
                        maxCount++;
                    }
                }
            }
        }
        return maxCount;
    }
}
