import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end ;
    int cost ;
    public Node( int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}

public class LeastCost {
    static int cityCount, busCount;
    static ArrayList<ArrayList<Node>> simulationList;
    static boolean[] isVisited;
    static int[] costArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCount = Integer.parseInt(br.readLine());
        busCount = Integer.parseInt(br.readLine());
        simulationList = new ArrayList<>();
        for (int i = 0; i < cityCount+1; i++) {
            simulationList.add(new ArrayList<>());
        }
        StringTokenizer st;
        isVisited = new boolean[cityCount + 1];
        costArray = new int[cityCount + 1];
        for (int i = 0; i < busCount; i++) {
            st = new StringTokenizer(br.readLine());
            int startToken = Integer.parseInt(st.nextToken());
            int endToken = Integer.parseInt(st.nextToken());
            int costToken = Integer.parseInt(st.nextToken());
            simulationList.get(startToken).add(new Node(endToken, costToken));
        }
        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());
        BFS(startPoint, endPoint);
        System.out.println(costArray[endPoint]);
    }

    static void BFS(int startPoint, int endPoint) {
        /*우선순위 큐를 쓸 경우 
        초기 cost배열 값의 세팅을 전부 다 큰 값으로 설정을 해준다.
        시작하는 지점의 좌표의 값은 cost 0으로 한다.
        어레이 리스트의 경우에는 인접리스트 형식으로 ARrayList를 두 번 감싸서 저장한 다음
        이동하게 하면 된다. 
        큐에 시작 지점의 값과 cost값을 넣어준다. 
        인접리스트의.get.의 모든 값들을 꺼내서 cost와 visited을 갱신하고
        조건에 만족할 때 cost 다음 값과 다음 q의 번호를 담는다. 
        마지막에 원하는 도착 지점의 값을 출력한다. 
        */
        PriorityQueue<Node> q = new PriorityQueue<>();
        Arrays.fill(costArray, Integer.MAX_VALUE);
        costArray[startPoint] = 0;
        q.add(new Node(startPoint,0));
        while (!q.isEmpty()){
            Node load = q.poll();
            if(!isVisited[load.end]){
                isVisited[load.end] = true;
                for (Node nextNode: simulationList.get(load.end)
                     ) {
                    if (!isVisited[nextNode.end] && costArray[nextNode.end] > costArray[load.end] + nextNode.cost){
                        costArray[nextNode.end] = costArray[load.end] + nextNode.cost;
                        q.add(new Node(nextNode.end,  costArray[nextNode.end]));
                    }
                }
            }
        }
    }
}
