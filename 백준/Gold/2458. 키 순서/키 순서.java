import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> lists;
    static boolean[][]isKnowMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentSize = Integer.parseInt(st.nextToken());
        int testCaseSize = Integer.parseInt(st.nextToken());
        lists = new ArrayList<>();
        isKnowMap = new boolean[studentSize][studentSize];
        for (int i = 0; i < studentSize; i++) {
            lists.add(new ArrayList<>());
            for (int j = 0; j < studentSize; j++) {
                if (i==j) isKnowMap[i][j] = true;
            }
        }
        isKnowMap= new boolean[studentSize][studentSize];
        for (int i = 0; i < testCaseSize; i++) {
            st = new StringTokenizer(br.readLine());
            int smallPerson = Integer.parseInt(st.nextToken())-1;
            int bigPerson = Integer.parseInt(st.nextToken())-1;
            lists.get(smallPerson).add(bigPerson);
        }
        for (int i = 0; i < studentSize; i++) {
            isVisited = new boolean[studentSize];
            DFS(i,i);
        }
        lists.clear();
        int answerCount = 0;
        for (int i = 0; i < studentSize; i++) {
            boolean flag = true;
           for (int j = 0; j < studentSize; j++) {
               if (i==j) continue;
               if (!isKnowMap[i][j]&&!isKnowMap[j][i]){
                   flag = false;
                   break;
               }
           }
            if (flag) answerCount++;
        }
        System.out.print(answerCount);
    }
    static boolean[]isVisited ;
    static void DFS(int checkNo,int startNo){
        if (isVisited[startNo]) return;
        isVisited[startNo] = true;
        for (int token : lists.get(startNo)
        ) {
            isKnowMap[checkNo][token] = true;
            DFS(checkNo,token);
        }
    }
    static void BFS(int startNo){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startNo);
        while (!q.isEmpty()){
            int curPos = q.poll();
            for (int token : lists.get(curPos)
                 ) {
                isKnowMap[startNo][token] = true;
                q.add(token);
            }
        }
    }
}