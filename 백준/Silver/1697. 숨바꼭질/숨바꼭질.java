import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Position{
        int curPos = 0;
        int time = 0;
        public Position(int curPos, int time) {
            this.curPos = curPos;
            this.time = time;
        }
    }
    final static int maxPos = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());
        isVisited = new boolean[maxPos];
        int answer = -1;
        if (startPos>endPos){
            answer = startPos-endPos;
        } else if (startPos == endPos) {
            answer = 0;
        } else{
            answer = BFS(startPos,endPos);
        }
        System.out.println(answer);
    }
    static boolean[] isVisited;
    static int BFS(int startPos,int endPos){
        int answer = 0;
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(startPos,0));
        while(!q.isEmpty()){
            Position nowPosition = q.poll();
            if (nowPosition.curPos==endPos) {
                answer = nowPosition.time;
                break;
            }
            isVisited[nowPosition.curPos] = true;
            if (checkRange(nowPosition.curPos+1)){
                if (!isVisited[nowPosition.curPos+1]){
                    q.add(new Position(nowPosition.curPos+1,nowPosition.time+1));
                }
            }
            if (checkRange(nowPosition.curPos-1)) {
                if (!isVisited[nowPosition.curPos-1]){
                    q.add(new Position(nowPosition.curPos-1,nowPosition.time+1));
                }
            }
            if (checkRange(nowPosition.curPos*2)) {
                if (!isVisited[nowPosition.curPos * 2]) {
                    q.add(new Position(nowPosition.curPos * 2, nowPosition.time + 1));
                }
            }
        }
        return answer;
    }
    static boolean checkRange(int pos){
        if (pos>=0&&pos<maxPos){
            return true;
        }
        return false;
    }

}
