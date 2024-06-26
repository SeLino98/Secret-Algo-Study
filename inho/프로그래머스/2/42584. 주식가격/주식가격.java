import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int priceSize = prices.length;
        int[] answer = new int[priceSize];
        Stack<Integer> stack = new Stack();
        
        // 스택에 인덱스를 넣는다!
        // 만약 값이 작아지는 시점이 등장한다면? -> 전의 인덱스 값을 빼고 현재 인덱스와의 차이 값을 넣는다. 
        for(int i = 0; i < priceSize; i++){
            while(!stack.isEmpty()&&prices[i]<prices[stack.peek()]){
                int value = stack.pop();
                answer[value] = i - value;
            }
            stack.push(i);
        }
        
        // 마지막까지 스택이 남는다면? 
        // 마지막 인덱스에서 뺀 인덱스까지 가격이 떨어지지 않은 것
        while(!stack.isEmpty()){
            int temp = stack.pop();
            answer[temp] = priceSize - temp - 1; 
        }
        
        
        
        // Queue<Integer> q = new ArrayDeque<>();
        // for(int token : prices){
        //     q.add(token);
        // }
        // //while문 안에 빼서 list에 값들 하나씩 비교 
        // ArrayList<Integer> answerList = new ArrayList<>();
        // int[] answer = new int[prices.length];
        // boolean [] isChecked = new boolean[prices.length];
        // int tmp = q.poll();
        // answerList.add(tmp);
        // while(!q.isEmpty()){
        //     int temp = q.poll();
        //     answerList.add(temp);
        //     for(int i = 0; i<answerList.size()-1; i++){
        //         int value = answerList.get(i);
        //         if(!isChecked[i]){
        //             if(temp>=value){ //주식 가격이 오른 경우 
        //                 answer[i]++;
        //             }else{//주식 가격이 내려간 경우 
        //                 answer[i]++;
        //                 isChecked[i] = true; 
        //             }   
        //         }
        //     }
        // }
        return answer;
    }
}