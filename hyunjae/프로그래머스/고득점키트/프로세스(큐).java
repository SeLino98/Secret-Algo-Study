import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 우선순위로 저장할 우선순위큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new int[]{priorities[i], i});
        }
        
        while (!pq.isEmpty() && !queue.isEmpty()) {
            // 큐에서 하나씩 빼서 확인하기
            int[] current = queue.poll();
            int priority = current[0];
            int index = current[1];
            
            // 조건에 해당되면 우선순위큐에서 빼고 정답+1하기
            if (priority == pq.peek()) {
                pq.poll();
                answer++;
                if (index == location) {
                    return answer;
                }
            } else {
                queue.add(current);
            }
        }
        return answer;
    }
}