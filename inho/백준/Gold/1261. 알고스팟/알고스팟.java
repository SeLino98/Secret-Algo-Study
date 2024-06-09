import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class AlgoNode implements Comparable<AlgoNode>{
    int yPos;
    int xPos;
    int cost;
    public AlgoNode(int yPos, int xPos, int cost) {
        this.yPos = yPos;
        this.xPos = xPos;
        this.cost = cost;
    }
    @Override
    public int compareTo(AlgoNode o) {
        return this.cost-o.cost;
    }
}

public class Main {
    static int rowSize, colSize;
    static boolean[][] isVisited;
    static int[][] map;
    static int[][] costMap;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        //맵 출발 시점은 1.1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());
        map = new int[rowSize+1][colSize+1];
        costMap = new int[rowSize+1][colSize+1];
        isVisited = new boolean[rowSize+1][colSize+1];
        for (int i = 1; i <= rowSize; i++) {
            char [] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]=='1'){
                    map[i][j+1] = 1;
                }else{
                    map[i][j+1] = 0;
                }
            }
        }
        BFS();
//        System.out.println("ASDF");
//        CostPrint();
        System.out.println(costMap[rowSize][colSize]);

    }
    static void BFS(){
        PriorityQueue<AlgoNode> q = new PriorityQueue<>();
        for (int i = 1; i <= rowSize; i++) {
            Arrays.fill(costMap[i],Integer.MAX_VALUE);
        }
        costMap[1][1] = 0;
        isVisited[1][1] = true;
        q.add(new AlgoNode(1,1,0));
        while (!q.isEmpty()){
            AlgoNode curNode = q.poll();
            int curY = curNode.yPos;
            int curX = curNode.xPos;
            int curCost = curNode.cost;
            if (curY==rowSize&&curX==colSize){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + curY;
                int nx = dx[i] + curX;
                if (ny>=1&&nx>=1&&ny<=rowSize&&nx<=colSize){
                    if (!isVisited[ny][nx]){
                        if (costMap[ny][nx]>curCost+map[ny][nx]){
                            costMap[ny][nx]=curCost+map[ny][nx];
                            isVisited[ny][nx] = true;
                            q.add(new AlgoNode(ny,nx,costMap[ny][nx]));
                        }
                    }
                }
            }
        }
    }
    static void Print(){
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void CostPrint(){
        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                System.out.print(costMap[i][j]+" ");
            }
            System.out.println();
        }
    }
}