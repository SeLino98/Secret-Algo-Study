import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질2 {
    static final int MAX_POSITION = 100_001;
    static boolean[] isVisited = new boolean[MAX_POSITION];
    static class Position {
        int curPos;
        int time;
        public Position(int curPos, int time) {
            this.curPos = curPos;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());
        int answer = BFS(startPos, endPos);
        System.out.println(answer);
    }
    static int BFS(int startPos, int endPos) {
        if (startPos > endPos) { //크면 걍 빼서 답으로 출력! 1씩 빼니까~
            return startPos - endPos;
        } else if (startPos == endPos) { // 같으면 큐로 넣을 필요도 없다!
            return 0;
        }
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(startPos, 0));
        isVisited[startPos] = true;
        while (!queue.isEmpty()) {
            Position nowPosition = queue.poll();
            if (nowPosition.curPos == endPos) {
                return nowPosition.time;
            }
            int[] nextPositions = new int[]{//3가지의 경우를 하나의 배열로 넣고 for문으로 돌면서 각 경우에 대해 q를 넣는다
                    nowPosition.curPos - 1,
                    nowPosition.curPos + 1,
                    nowPosition.curPos * 2
            };
            for (int nextPos : nextPositions) {
                if (isWithinRange(nextPos) && !isVisited[nextPos]) { //각 배열마다 배열의 범위를 체크를 해준다 .
                    isVisited[nextPos] = true;  //해당 범위 안에 있는 녀석이면 넣어준다
                    queue.add(new Position(nextPos, nowPosition.time + 1));
                }
            }
        }
        return -1; //값이 없는 경우
    }
    static boolean isWithinRange(int position) {
        return position >= 0 && position < MAX_POSITION;
    }
}
