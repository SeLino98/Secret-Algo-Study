
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class ZeldaNode implements Comparable<ZeldaNode>{
    int yPos;
    int xPos;
    int cost;
    public ZeldaNode(int yPos, int xPos, int cost) {
        this.yPos = yPos;
        this.xPos = xPos;
        this.cost = cost;
    }
    @Override
    public int compareTo(ZeldaNode o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main {
    static int mapSize ;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] costMap;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count =1;
        while (true){
            mapSize = Integer.parseInt(br.readLine());
            if (mapSize==0) break;
            map = new int[mapSize][mapSize];
            costMap = new int[mapSize][mapSize];
            isVisited = new boolean[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }//맵을 입력받는다.
            Dijkstra();
            sb.append("Problem ").append(count).append(": ").append(costMap[mapSize-1][mapSize-1]);
            sb.append("\n");
            count++;
        }
        System.out.println(sb);
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
    }
    static void Dijkstra(){
        PriorityQueue<ZeldaNode> q = new PriorityQueue<>();
        for (int i = 0; i < mapSize; i++) {
            Arrays.fill(costMap[i],Integer.MAX_VALUE);
        }
        isVisited[0][0] = true;
        costMap[0][0] = map[0][0];
        q.add(new ZeldaNode(0,0,map[0][0]));
        while (!q.isEmpty()){
            ZeldaNode node = q.poll();
            int curX = node.xPos;
            int curY = node.yPos;
            int curCost = node.cost;
            //꺼낸 노드의 xy값이 마지막 값이면 종료한다.
            if (curY==mapSize-1&&curX==mapSize-1){
//                System.out.println("ASDF");
                return;
            }
            for (int i = 0; i < 4; i++) {//for로 네방향에서의 값들을 고려한다.
                int nx = curX+dx[i];
                int ny = curY+dy[i];
                if (nx>=0&&ny>=0&&nx<mapSize&&ny<mapSize){
                    if (isVisited[ny][nx]) continue;//방문체크와 배열 값을 넘는지 체크를 한다.
                    isVisited[ny][nx] = true;
                    if (costMap[ny][nx]>curCost+map[ny][nx]){
                        costMap[ny][nx]=curCost+map[ny][nx]; //다음으로 넘어가는 값이 현재값보다 클 때 현재값으로 다음값을 갱신하고
                        q.add(new ZeldaNode(ny,nx,costMap[ny][nx]));    //큐에 담는다.
                    }
                }
            }
        }
    }
}
