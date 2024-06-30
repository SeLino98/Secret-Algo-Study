import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            pq.add(priority);
        }
        int n = priorities.length;
//포인터 역할을 할 i설정
        int i = -1;
        while (!pq.isEmpty()) {
//큐에서 하나씩 꺼내는것 대신 한칸씩 뒤로 탐색
          i = (i + 1) % n;
//이미 지워진 데이터면 넘어가기
           if (priorities[i] == 0) {
                continue;
            }
//조건에 맞는 경우 해당 부분0으로지우고 순서1증가
           if (priorities[i] == pq.peek()) {
                pq.poll();
                answer++;
                priorities[i] =0;
                if (i == location) {
                    return answer;
                }
            }
      
        }
        return 0;
    }
}