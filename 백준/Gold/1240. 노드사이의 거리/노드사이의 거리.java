import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static class Node{
        int curEdge;
        int curCost;
        public Node(int curEdge, int curCost) {
            this.curEdge = curEdge;
            this.curCost = curCost;
        }
    }
    static int wantKnowNodeSize, edgeSize;
    static ArrayList<ArrayList<Node>> list ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        edgeSize = Integer.parseInt(st.nextToken());
        wantKnowNodeSize = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= edgeSize; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeSize-1; i++) {
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            int costNode = Integer.parseInt(st.nextToken());
            list.get(firstNode).add(new Node(secondNode, costNode));
            list.get(secondNode).add(new Node(firstNode,costNode));
        }
        for (int i = 0; i < wantKnowNodeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int startPos = Integer.parseInt(st.nextToken());
            int endPos = Integer.parseInt(st.nextToken());
            isVisited = new boolean[edgeSize+1];
            int answer = BFS(startPos,endPos);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    static boolean[]isVisited;
    static int BFS(int startPos,int endPos){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startPos,0));
        while (!q.isEmpty()){
            Node curNode = q.poll();
            isVisited[curNode.curEdge] = true;
            if (curNode.curEdge==endPos){
                return curNode.curCost;
            }
            for (Node token: list.get(curNode.curEdge)) {
                if (isVisited[token.curEdge]) continue;
                q.add(new Node(token.curEdge,token.curCost+curNode.curCost));
            }
        }
        //가면서 해당 값을 찾으면 종료 -> 현재 코스트 값을 반환한다. 없으면 0리턴
        return 0;
    }
}
