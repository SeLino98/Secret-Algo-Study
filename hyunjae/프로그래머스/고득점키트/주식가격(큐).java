import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        //정답배열 미리 생성 바로바로 +1해주기 위해
        int[] answer = new int[n];
        //조건에 맞는 인덱스들을 저장할 큐
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty()) {
                int temp2 = queue.size();
                
                for (int j = 0; j < temp2; j++) {
                    int temp = queue.poll();
                    //1초씩 지났으니 각 정답의 인덱스 +1
                    answer[temp]++;
                    //만약 계속 조건에 부합한다면(주식의 가격이 떨어지지 않았으면)
                    if(prices[temp]<=prices[i]) {
                        //다시 큐에 넣기
                        queue.add(temp);
                    }
                }
            }
            //해당 주식가격의 인덱스 넣기
            queue.add(i);
        }
        return answer;
    }
}