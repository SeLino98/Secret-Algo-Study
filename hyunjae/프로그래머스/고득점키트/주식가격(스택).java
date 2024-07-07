import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //각 스택의 윗부분이 지금 가격보다 높은지확인
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int temp = stack.pop();
                //높으면 지금 인덱스에서 원래 인덱스 빼면 초가나옴
                answer[temp] = i-temp;
            }
            stack.push(i);
        }
        //계속 가격 떨어지지않은 애들 처리
        while(!stack.isEmpty()){
            int temp = stack.pop();
            //총 길이에서 각자 인덱스+1 한 값을 뺴주기
            answer[temp] = n-(temp+1);
        }
        return answer;
    }
}