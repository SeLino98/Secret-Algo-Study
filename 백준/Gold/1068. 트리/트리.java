import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int arrSize;
    static boolean[] isDeleted;
    static int[] arrTree;
    static int deleteNodeNo;
    static int rootPos;

    public static void main(String[] args) throws IOException {

        //일차원 배열엔 제거된 노드를
        //2*n차원 배열엔 노드들 중에서 깊이를 갱신한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrSize = Integer.parseInt(br.readLine());
        isDeleted = new boolean[arrSize];
        arrTree = new int[arrSize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            int startPos = Integer.parseInt(st.nextToken());
            arrTree[i] = startPos;
            if (startPos==-1) rootPos = i;
        }
        deleteNodeNo = Integer.parseInt(br.readLine());//지울 노드
        BFS(deleteNodeNo,true);
//        for (int i = 0; i < isDeleted.length; i++) {
//            System.out.print(isDeleted[i]+" ");
//        }
//        System.out.println();
        BFS(rootPos,false);
        System.out.print(answerCount);
    }
    static int answerCount;
    static void BFS(int delNo, boolean isDelTask){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(delNo);
        if (arrTree[delNo]==-1&&isDeleted[delNo]) {
            answerCount =0;
            return;
        }
        while (!q.isEmpty()){
            int curNum = q.poll();
            boolean flag = false;
            isDeleted[curNum] = true;
            for (int i = 0; i < arrSize; i++) {
                if (isDelTask){//지우는 작업이면
                    if (arrTree[i]==curNum){//1이 하나라도 있을 때
                        q.add(i);
                    }
                }else{//지우는 작업이 아니면
                    if (!isDeleted[i]){
                        if (arrTree[i]==curNum){//1이 하나라도 있을 때
                            flag = true; //자식 노드가 잇다는 것이다.
                            q.add(i);
                        }
                    }
                }
            }
            if (!isDelTask&&!flag) answerCount++;
        }
    }
}
