import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    static class Node {
        int curPos;
        int cost;
        public Node(int curPos, int cost) {
            this.curPos = curPos;
            this.cost = cost;
        }

    }
    static int nodeSize;
    static boolean[] isVisited;
    static int max ;
    static int maxVerPos;
    static ArrayList<ArrayList<Node>> treeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        max = Integer.MIN_VALUE;
        nodeSize = Integer.parseInt(br.readLine());
        treeList = new ArrayList<>();
        isVisited = new boolean[nodeSize+1];
        for (int i = 0; i < nodeSize+1; i++) {
            treeList.add(new ArrayList<>());
        }
        for (int i = 1; i < nodeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int parentsNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            treeList.get(parentsNode).add(new Node(childNode,cost));
            treeList.get(childNode).add(new Node(parentsNode,cost));
        }
        isVisited[1] = true;
        DFS(1,0);
//        System.out.println(maxVerPos+"_"+max);
//        for (int i = 0; i <isVisited.length; i++) {
//            System.out.print(isVisited[i]+" ");
//        }
//        System.out.println();
        isVisited = new boolean[nodeSize+1];
        isVisited[maxVerPos] = true;
        DFS(maxVerPos,0);
//        for (int i = 0; i <isVisited.length; i++) {
//            System.out.print(isVisited[i]+" ");
//        }
//        System.out.println(maxVerPos+"_"+max);
        System.out.println(max);
        br.close();
    }
    static void DFS(int pos, int weigh){
        if (max < weigh){
            max = weigh;
            maxVerPos = pos;
        }
        for (Node token: treeList.get(pos)
             ) {
            if (isVisited[token.curPos]) continue;
            isVisited[token.curPos] = true;
            DFS(token.curPos, weigh+ token.cost);
            isVisited[token.curPos] = false;
        }
    }
}
