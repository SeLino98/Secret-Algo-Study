import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class SpecificNode implements Comparable<SpecificNode>{
    int endPos;
    int cost;

    public SpecificNode(int endPos, int cost) {
        this.endPos = endPos;
        this.cost = cost;
    }
    @Override
    public int compareTo(SpecificNode o) {
        return this.cost -o.cost;
    }

}
public class Main {
    static int vertex,edge;
    static ArrayList<ArrayList<SpecificNode>> specList;
    static int[] costList;
    static boolean[] isVisited;

    static int startVert, endVert;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        specList = new ArrayList<>();
        costList = new int[vertex+1];
        isVisited = new boolean[vertex+1];

        for (int i = 0; i < vertex+1; i++) { //사이즈 하나 더 받는다.
            specList.add(new ArrayList<SpecificNode>());
        }
        for (int i = 1; i < edge+1; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            specList.get(startPoint).add(new SpecificNode(endPoint,cost));
            specList.get(endPoint).add(new SpecificNode(startPoint,cost));
        }
        st = new StringTokenizer(br.readLine());
        startVert = Integer.parseInt(st.nextToken());
        endVert = Integer.parseInt(st.nextToken());

        int route1 = 0;
        route1 +=BFS(1,startVert);
        route1 += BFS(startVert,endVert);
        route1 += BFS(endVert,vertex);

        int route2 = 0;
        route2 += BFS(1,endVert);
        route2 += BFS(endVert,startVert);
        route2 += BFS(startVert,vertex);

        if(costList[vertex]==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(route2,route1));
        }
    }
    static int BFS(int pos1, int pos2){
        PriorityQueue<SpecificNode> q = new PriorityQueue<>();
        Arrays.fill(costList,Integer.MAX_VALUE);
        isVisited = new boolean[vertex+1];
        costList[pos1] = 0;
        q.add(new SpecificNode(pos1,0));
        while (!q.isEmpty()){
            SpecificNode node = q.poll();
            int curPos = node.endPos;
            if (curPos==pos2) return costList[pos2];
            if (!isVisited[curPos]){
                isVisited[curPos] = true;
                for (SpecificNode token: specList.get(curPos)) {
                    if (costList[token.endPos] > token.cost + costList[curPos]){
                        costList[token.endPos] = token.cost + costList[curPos];
                        q.add(new SpecificNode(token.endPos,costList[token.endPos]));
                    }
                }
            }
        }
        return costList[pos2];
    }
}
