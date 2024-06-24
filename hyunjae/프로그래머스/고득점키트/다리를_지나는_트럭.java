import java.util.*;

class Solution {
    class Timer {
        int weight;
        int time;

        public Timer(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Timer> timer = new LinkedList<>();
        int nowWeight = 0;
        int index = 0;

        while (index < truck_weights.length || !timer.isEmpty()) {
            // 시간 경과
            answer++;

            // 다리에서 트럭 제거
            if (!timer.isEmpty() && timer.peek().time == answer) {
                nowWeight -= timer.poll().weight;
            }

            // 새로운 트럭 추가
            if (index < truck_weights.length && nowWeight + truck_weights[index] <= weight) {
                timer.add(new Timer(truck_weights[index], answer + bridge_length));
                nowWeight += truck_weights[index];
                index++;
            }
        }
        
        return answer;
    }
}