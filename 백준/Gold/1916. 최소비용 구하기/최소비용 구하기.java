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

public class Main {
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
//        q.add(new Node(startPoint,endPoint,0));
//        while(q.isEmpty()){
//            //cost를 기준으로 뽑는다.
//            Node load = q.poll();
//            isVisited[load.start] = true;
//            if(load.end == endPoint){//도착지점에 도착하면 종료한다.
//                costArray[endPoint] = load.cost;
//                break;
//            }
//            if (!isVisited[load.end]){
//                if (costArray[load.end]< load.cost){
//                    q.add()//큐로 넣는데, 어레이에 저장된 start가 end인 애들을 담는다.
//
//                }
//            }
//            //cost가 최소가 되면 갱신하고 그 노드를 큐에 넣는다.

//        for (int i = 0; i < simulationList.size(); i++) {
//            //node를 다 집어 넣고
//            if (simulationList.get(i).start==startPoint){
//                q.add(simulationList.get(i));
//            }
//        }