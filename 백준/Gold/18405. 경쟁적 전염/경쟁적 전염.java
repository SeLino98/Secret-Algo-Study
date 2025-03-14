import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static int mapSize,virusSize ;
    static boolean [][] isVisitedMap;
    static int [][] map ;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static PriorityQueue<VirusInfo> posList;
    static class VirusInfo implements Comparable<VirusInfo>{
        int posX = 0;
        int posY = 0;
        int value = 0;

        public VirusInfo( int posY, int posX, int value){
            this.posX = posX;
            this.posY = posY;
            this.value = value;
        }
        @Override
        public int compareTo(VirusInfo o){
            return this.value - o.value;
        }

    }
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        mapSize = Integer.parseInt(st.nextToken());
        virusSize = Integer.parseInt(st.nextToken());
        map = new int[mapSize][mapSize];
        isVisitedMap = new boolean[mapSize][mapSize];
        posList = new PriorityQueue<>();

        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                int tmpValue = Integer.parseInt(st.nextToken());
                if (tmpValue>0){
                    posList.add(new VirusInfo(i,j,tmpValue));
                }
                map[i][j] = tmpValue;
            }
        }
        st = new StringTokenizer(br.readLine());
        int findTime = Integer.parseInt(st.nextToken());
        int findPosY = Integer.parseInt(st.nextToken())-1;
        int findPosX = Integer.parseInt(st.nextToken())-1;
        while (findTime --> 0){
            if (!posList.isEmpty()){
                VirusInfo pos = posList.peek();
                BFS(pos.posY,pos.posX);
            }
        }
        System.out.print(map[findPosY][findPosX]);
    }

    static void BFS(int i, int j){
        Queue<VirusInfo> q = new ArrayDeque<>();
        isVisitedMap[i][j] = true;
        while (!posList.isEmpty()){
            VirusInfo curPos = posList.poll();
            for (int k = 0; k < 4; k++) {
                int nextPosY = curPos.posY + dy[k];
                int nextPosX = curPos.posX + dx[k];
                if (nextPosX>=0&&nextPosY>=0&&nextPosY<mapSize &&nextPosX<mapSize){
                    if (isVisitedMap[nextPosY][nextPosX]||map[nextPosY][nextPosX]>0) continue;
                    isVisitedMap[nextPosY][nextPosX] = true;
                    map[nextPosY][nextPosX] = curPos.value;
                    q.add(new VirusInfo(nextPosY,nextPosX,curPos.value));
                }
            }
        }
        posList.addAll(q);
    }
}
