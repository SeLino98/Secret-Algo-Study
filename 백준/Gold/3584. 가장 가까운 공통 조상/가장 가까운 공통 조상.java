import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> treeList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < testCase; t++) {
            int ListSize = Integer.parseInt(br.readLine());
            treeList = new ArrayList<>();
            isVisited = new boolean[ListSize+1];
            for (int i = 0; i <= ListSize; i++) {
                treeList.add(new ArrayList<>());
            }
            for (int i = 0; i < ListSize-1; i++) {
                st = new StringTokenizer(br.readLine());//반대로 연결
                //ArrayList의 값을 반대로 저장한다.
                int startNo = Integer.parseInt(st.nextToken());
                int endNo = Integer.parseInt(st.nextToken());
                treeList.get(endNo).add(startNo);
            }
            st = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            findParentFunction(firstNode);
            sb.append(findParentFunction(secondNode)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    static int findParentFunction(int curPos){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(curPos);
        while (!q.isEmpty()){
            int curEdge = q.poll();
            if (isVisited[curEdge]) return curEdge;
            isVisited[curEdge] =true;
            for (int token:treeList.get(curEdge)
                 ) {
                q.add(token);
            }
        }
        return 0;
    }
}
