import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Position implements Comparable<Position>{
    int curPos ;
    int cost;
    public Position(int curPos, int cost) {
        this.curPos = curPos;
        this.cost = cost;
    }
    @Override
    public int compareTo(Position o) {
        return this.cost - o.cost;
    }
}
public class HideAndSeek {
    static int startPos,endPos;
    final static int MaxPos = 100_001;
    static boolean [] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N점 K점
        isVisited = new boolean[MaxPos];
        startPos = Integer.parseInt(st.nextToken());
        endPos  = Integer.parseInt(st.nextToken());
        int answer = BFS();
        System.out.println(answer);
    }
    public static int BFS(){
        //큐에 넣고
        PriorityQueue<Position> node = new PriorityQueue<>();
        node.add(new Position(startPos,0));
        while (!node.isEmpty()){
            Position curNode = node.poll();
            if (curNode.curPos == endPos){//endPos에 도착하면 종료
                return curNode.cost;
            }
            if (curNode.curPos<MaxPos){
                if (!isVisited[curNode.curPos]){
                    isVisited[curNode.curPos] = true;
                    if (curNode.curPos<2*endPos- startPos){
                        //*2일 때
                        node.add(new Position(curNode.curPos*2, curNode.cost));
                    }
                    if (curNode.curPos>0){//-1일 때
                        node.add(new Position(curNode.curPos-1, curNode.cost+1));
                    }
                    if (curNode.curPos<endPos){//+1일 때
                        node.add(new Position(curNode.curPos+1, curNode.cost+1));
                    }
                }
            }
        }
        return 0;
    }
}
