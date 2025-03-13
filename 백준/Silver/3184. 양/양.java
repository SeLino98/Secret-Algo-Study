import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [][] map ;
    static boolean[][] isVisitedMap ;
    static int rowSize, colSize;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new char[rowSize][colSize];
        isVisitedMap = new boolean[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            char [] tmpList = br.readLine().toCharArray();
            for (int j = 0; j < colSize; j++) {
                map[i][j] = tmpList[j];
            }
        }

        int [] answer = new int[2];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!isVisitedMap[i][j] && map[i][j] != '#'){
                    int[] tmpAnswer = new int[2];
                    isVisitedMap[i][j] = true;
                    if (map[i][j]=='o') tmpAnswer = BFS(i, j, 1, 0);
                    if (map[i][j]=='v') tmpAnswer = BFS(i,j,0,1);
                    if (map[i][j]=='.')tmpAnswer = BFS(i,j,0,0);
                    for (int z = 0; z < 2; z++) {
                        answer[z] += tmpAnswer[z];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
    static int[] BFS(int i, int j, int sheepCnt, int wolfCnt){
        int wolf = wolfCnt;
        int sheep = sheepCnt;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        while (!q.isEmpty()){
            int []curPos = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = curPos[0]+dy[k];
                int nx = curPos[1]+dx[k];
                if (ny>=0 && nx>=0&&ny<rowSize&&nx<colSize){
                    if (isVisitedMap[ny][nx]||map[ny][nx]=='#') continue;
                    isVisitedMap[ny][nx] = true;
                    if (map[ny][nx]=='o') sheep++;
                    if (map[ny][nx]=='v') wolf++;
                    q.add(new int[]{ny,nx});
                }
            }
        }
        int [] infoList = new int[2];
        if (wolf>=sheep){
            infoList[1] = wolf;
        }else{
            infoList[0] = sheep;
        }
        return infoList;
    }
}
