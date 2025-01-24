import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int rowSize,colSize;
    static char [][] map ;
    static int [] answer = new int[2];
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [][] isVisitedMap;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new char[rowSize][colSize];
        isVisitedMap = new boolean[rowSize][colSize];
        /*
        빈 공간일 때 탐색, 양과 늑대의 갯수를 세고 리턴,
        비교하고 더 작은 쪽으로 양과 늑대를 분배
        * */
        for (int r = 0; r < rowSize; r++) {//맵에 저장
            char [] tmpList = br.readLine().toCharArray();
            for (int c = 0; c < colSize; c++) {
                map[r][c] = tmpList[c];
            }
        }

        for (int r = 0; r < rowSize; r++) {//맵에 저장
            for (int c = 0; c < colSize; c++) {
                if (map[r][c]!='#'&&!isVisitedMap[r][c]){//빈공간이면 탐색
                    int [] tmpCntAnimal = BFS(r,c);
                    calAnimalCount(tmpCntAnimal);
                }
            }
        }
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.print(sb);
    }
    static void calAnimalCount(int [] countAnimal){
        if (countAnimal[0]>countAnimal[1]){
            countAnimal[1] = 0;
        }else{
            countAnimal[0] = 0;
        }
        answer[0] += countAnimal[0];
        answer[1] += countAnimal[1];
    }
    static void countAnimal(int ny, int nx){
        if (map[ny][nx] == 'v'){//늑대
            countAnimal[1]++;
        } else if (map[ny][nx] == 'k') { //양
            countAnimal[0]++;
        }
    }
    static int [] countAnimal ;
    static int [] BFS(int i, int j){
        countAnimal = new int[2];
        countAnimal(i,j);//0 은 양 1 은 늑대
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        isVisitedMap[i][j] = true;
        while (!q.isEmpty()){
            int []posXY = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = dy[k] + posXY[0];
                int nx = dx[k] + posXY[1];
                if (ny>=0&& nx>=0 && ny<rowSize && nx<colSize){
                    if (!isVisitedMap[ny][nx]&&map[ny][nx]!='#'){
                        isVisitedMap[ny][nx] = true;
                        countAnimal(ny,nx);
                        q.add(new int[]{ny,nx});
                    }
                }
            }
        }
        return countAnimal;
    }
}