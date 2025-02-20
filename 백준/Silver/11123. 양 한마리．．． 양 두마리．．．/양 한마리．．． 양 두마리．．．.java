import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowSize,colSize;
    static StringTokenizer st ;
    static boolean [][]isVisitedMap ;
    static char [][] map ;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            isVisitedMap = new boolean[rowSize][colSize];
            map = new char[rowSize][colSize];
            for (int r = 0; r < rowSize; r++) {
                char[] list = br.readLine().toCharArray();
                for (int c = 0; c < colSize; c++) {
                    map[r][c] = list[c];
                }
            }
            int answerCount = 0;
            for (int r = 0; r < rowSize; r++) {
                for (int c = 0; c < colSize; c++) {
                    if (!isVisitedMap[r][c]&&map[r][c] == '#') {
                        BFS(r,c);
                        answerCount++;
                    }
                }
            }
            sb.append(answerCount).append('\n');
        }
        System.out.print(sb);
    }
    static void BFS(int posY,int posX){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{posY,posX});
        isVisitedMap[posY][posX] = true;
        while (!q.isEmpty()){
            int []curPos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = curPos[0]+dy[i];
                int nextX = curPos[1]+dx[i];
                if (nextX>=0&& nextY>=0&&nextY<rowSize &&nextX<colSize){
                    if (isVisitedMap[nextY][nextX]) continue;
                    if (map[nextY][nextX]=='#'){
                        isVisitedMap[nextY][nextX] = true;
                        q.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}