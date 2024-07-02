import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        //완료 갯수셀 변수 만들기 와일문끝내기위해
        int doTask = 0;
        //몇초까지 왔는지 확인할 변수만들기
        int time = 0;
        //PQ로 가득한 배열만들기 각 요청시간마다 작업시간 보기용
        PriorityQueue<Integer>[] array = new PriorityQueue[1001];

        for (int i = 0; i < n; i++) {
            int requestTime = jobs[i][0];
            int workTime = jobs[i][1];
            //해당요청시간에 pq없으면 생성
            if (array[requestTime] == null) {
                array[requestTime] = new PriorityQueue<>();
            }
            //해당요청시간에 작업시간 넣기
            array[requestTime].offer(workTime);
        }

        while (doTask < n) {
            int index = -1;
            int work = Integer.MAX_VALUE;
            

            //지금 초까지 순회하면서 가장 짧은 작업 찾기
            for (int i = 0; i <= time && i < array.length; i++) {
                if (array[i] != null && !array[i].isEmpty()) {
                    if (array[i].peek() < work) {
                        index = i;
                        work = array[i].peek();
                    }
                }
            }

            //찾았으면 그 작업 빼내고 작업시간만큼 늘려주기
            //못찾았으면 time 1초 지나게하기
            if (index != -1) {
                time += array[index].poll();
                answer += time - index;
                doTask++;
            } else {
                time++;
            }
        }
        return answer / n;
    }
}