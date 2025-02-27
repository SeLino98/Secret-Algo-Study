import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int personCount;
    static boolean [] isVisitedList;
    static int [] personRelationList ;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //BFS 1, 2까지 출력.
        personCount = Integer.parseInt(br.readLine());
        isVisitedList = new boolean[personCount+1];
        personRelationList = new int[personCount+1];
        int listSize = Integer.parseInt(br.readLine());
        for (int i = 0; i <= personCount; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < listSize; i++) {
            st = new StringTokenizer(br.readLine());
            int firstToken = Integer.parseInt(st.nextToken());
            int secondToken = Integer.parseInt(st.nextToken());
            list.get(firstToken).add(secondToken);
            list.get(secondToken).add(firstToken);
        }
        BFS(1);
        int answer = 0;
        for (int i = 1; i < personRelationList.length; i++) {
            if (personRelationList[i]<=2&&personRelationList[i]>=1){
                answer++;
            }
        }
        System.out.print(answer);
        //이미 방문한 노드는 방문 노노

    }
    static void BFS(int startPos){
        Queue<int[]> q = new ArrayDeque<>();
        isVisitedList[startPos] = true;
        q.add(new int[]{startPos,0});
        int [] curPos;
        while (!q.isEmpty()){
            curPos = q.poll();
            for(int nextPos : list.get(curPos[0])){
                if (isVisitedList[nextPos]) continue;
                isVisitedList[nextPos] = true;
                q.add(new int[]{nextPos,curPos[1]+1});
                personRelationList[nextPos] = curPos[1]+1;
            }
        }
    }
}