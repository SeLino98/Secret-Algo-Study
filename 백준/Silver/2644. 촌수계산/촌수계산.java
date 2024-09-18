import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static boolean [] isVisited;
    static int startPos, endPos ;
    static ArrayList<ArrayList<Integer>> personList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine())+1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        startPos = Integer.parseInt(st.nextToken());
        endPos = Integer.parseInt(st.nextToken());

        int size = Integer.parseInt(br.readLine());
        personList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            personList.add(new ArrayList<>());
        }
        for (int s = 0; s < size; s++) {
            st = new StringTokenizer(br.readLine());
            int firstPos = Integer.parseInt(st.nextToken());
            int secondPos = Integer.parseInt(st.nextToken());
            personList.get(firstPos).add(secondPos);
            personList.get(secondPos).add(firstPos);
        }
        isVisited = new boolean[N+1];
        int answer = BFS();
        System.out.print(answer);
    }

    static int BFS(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startPos,0});
        int answer = -1;
        isVisited[startPos] = true;
        while(!q.isEmpty()){
            int [] curInfo = q.poll();
            // 인덱스
            //0은 현재 위치
            //1은 현재 단계
            if (endPos == curInfo[0]){
                return curInfo[1];//답 찾으면 종료 
            }
            for (int i = 0; i < personList.get(curInfo[0]).size(); i++) {
                int tmpVal = personList.get(curInfo[0]).get(i);
                if (isVisited[tmpVal])continue;
                isVisited[tmpVal] = true;
                q.add(new int[]{tmpVal,curInfo[1]+1});
            }
        }
        return answer;
    }
}
