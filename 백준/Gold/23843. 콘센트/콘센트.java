import java.util.*;
import java.io.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int deviceTotal = Integer.parseInt(st.nextToken());
        int powerOutletSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> powerQueue = new PriorityQueue<>();//오름 차순 정렬
        PriorityQueue<Integer> waitQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });//역순 정렬
        int answer = 0;
        for (int i = 0; i < deviceTotal; i++) {
            waitQueue.add(Integer.parseInt(st.nextToken()));
        }
        while (!waitQueue.isEmpty()||!powerQueue.isEmpty()){
            while (powerQueue.size() < powerOutletSize && !waitQueue.isEmpty()) {
                Integer nextDevice = waitQueue.poll();
                if (nextDevice != null) {
                    powerQueue.add(nextDevice);
                }
            }
            //파워큐에서 가장 금방 끝나는 애를 꺼낸다.
            //정답을 더한다.
            int completeTime = 0;
            if (!powerQueue.isEmpty()){
                completeTime = powerQueue.poll();
            }
            answer += completeTime;
            // 꺼낸 후 파워큐에 남아있는 값들을 차감한다. 어레이리스트
            //0이하가 되면 큐에 넣지 않는다.
            //아닌애들은 파워큐에 다시 넣는다.
            ArrayList<Integer> tmpList = new ArrayList<>();
            while (!powerQueue.isEmpty()){
                int tmpTime = powerQueue.poll() - completeTime;
                if (tmpTime>0) tmpList.add(tmpTime);
            }
            powerQueue.addAll(tmpList);
        }
        System.out.print(answer);
    }
}
