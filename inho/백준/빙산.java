import java.io.IOException;
import java.io.*;
import java.util.*;

public class 빙산 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int rowSize, colSize;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static int [][] map;
    static int [][] bergCountMap;
    static boolean [][] isVisitedMap;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize][colSize];// 값할당.
        for (int i = 0; i < rowSize; i++) {//맵 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answerYear = 0;
        //이동하면서 탐색 1 _ 1년 흘려보내기
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (map[i][j] > 0){
                    isVisitedMap = new boolean[rowSize][colSize];
                    deleteIceBergBFS(j,i); //1년을 흘려보내기 1차수 진행
                    answerYear++;
                    int bergCount = findBergCount();
                    if (bergCount>=2){
                        System.out.print(answerYear);
                        return;
                    }else if (bergCount == 0){
                        System.out.println(0);
                        return;
                    }
                    i = 0;
                    j = 0;
                }
            }
        }
        System.out.println(answerYear);
    }
    static int findBergCount(){
        //이동하면서 탐색 2 _ 섬갯수 확인
        int bergCount = 0;
        isVisitedMap = new boolean[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (map[i][j] > 0 && !isVisitedMap[i][j]){
                    bergCount++;
                    checkIceBergCount(i,j);
                }
            }
        }
        return bergCount;
    }

    //물확인 후 제거 작업 2
    static void deleteIceBergBFS(int x, int y){//j i
        Queue<int [] > q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        isVisitedMap[y][x] = true;
        while (!q.isEmpty()){
            int [] curPos = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + curPos[0];
                int nx = dx[i] + curPos[1];
                if (ny>=0&&nx>=0&&ny<rowSize&&nx<colSize){
                    if (isVisitedMap[ny][nx]) continue;
                    if (map[ny][nx]>0){//주위가 섬일 경우
                        q.add(new int[]{ny,nx});
                        isVisitedMap[ny][nx] = true;
                    }else{//주위 바다일 경우
                        map[curPos[0]][curPos[1]] -= 1;
                    }
                }
            }
        }
    }
    //섬 갯수 확인 3
    static void checkIceBergCount(int y, int x){
        Queue<int [] > q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        isVisitedMap[y][x] = true;
        while (!q.isEmpty()){
            int [] curPos = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + curPos[0];
                int nx = dx[i] + curPos[1];
                if (ny>=0&&nx>=0&&ny<rowSize&&nx<colSize){
                    if (isVisitedMap[ny][nx]) continue;
                    if (map[ny][nx]>0){//주위가 섬일 경우
                        q.add(new int[]{ny,nx});
                        isVisitedMap[ny][nx] = true;
                    }
                }
            }
        }
    }
}
