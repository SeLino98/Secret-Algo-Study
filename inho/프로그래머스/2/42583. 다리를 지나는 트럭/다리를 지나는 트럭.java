import java.util.*;
class Solution {
     public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 다리를 나가는 트럭을 먼저 본다.
        // 나가는 시간이 맞다 -> 리스트에서 제외
        Queue<Integer> truck_q = new LinkedList<>();
        Queue<int[]> truck_go = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            truck_q.add(truck_weights[i]);
        }
        int cur_weight = 0;
        while(!truck_q.isEmpty() || !truck_go.isEmpty()){
            if(!truck_go.isEmpty() && truck_go.peek()[0] <= answer){
                int [] temp = truck_go.poll();
                cur_weight -= temp[1];
            }
            // 트럭 사이즈가 1개이상, 무게가 작거나 같다면
            if(!truck_q.isEmpty() && truck_go.size() + 1 <= bridge_length
                    && cur_weight + truck_q.peek() <= weight){
                int temp = truck_q.poll();
                cur_weight += temp;
                truck_go.add(new int [] {answer + bridge_length,temp});
            }
            answer++;
        }
        return answer;
    }
}