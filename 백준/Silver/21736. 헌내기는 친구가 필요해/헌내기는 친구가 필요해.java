import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,-1,0,1};
    static int [][] map ;
    static boolean [][] isVisited;
    static int rowSize,colSize;
    static char []tmpChar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        int startPosX = 0 ;//col
        int startPosY = 0 ;//row
        map = new int[rowSize][colSize];
        isVisited = new boolean[rowSize][colSize];
        //맵저장
        for (int i = 0; i < rowSize; i++) {
            tmpChar = br.readLine().toCharArray();
            for (int j = 0; j < colSize; j++) {
                switch (tmpChar[j]){
                    case 'O':
                        map[i][j] = 0;
                        break;
                    case 'P':
                        map[i][j] = 1;
                        break;
                    case 'X':
                        map[i][j] = -1;
                        break;
                    case 'I':
                        startPosY = i;
                        startPosX = j;
                        break;
                    default: break;
                }
            }
        }
        int answer = BFS(startPosX,startPosY);
        if (answer==0){
            System.out.println("TT");
        }else{
            System.out.println(answer);
        }
    }
    static int BFS(int startPosX, int startPosY){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startPosY,startPosX});
        int answer = 0;
        isVisited[startPosY][startPosX] = true;
        while (!q.isEmpty()){
            int[] posXY = q.poll(); //0이 y , 1이 x
            for (int i = 0; i < 4; i++) {
                int nx = posXY[1] + dx[i];
                int ny = posXY[0] + dy[i];
                if (nx>=0&&ny>=0&&ny<rowSize&&nx<colSize){
                    if (isVisited[ny][nx]) continue;
                    isVisited[ny][nx] = true;
                    if (map[ny][nx]==0){//통과
                        q.add(new int[]{ny,nx});
                    }else if (map[ny][nx] == 1){//
                        answer++;
                        q.add(new int[]{ny,nx});
                    }
                }
            }

        }
        return answer;
    }
}