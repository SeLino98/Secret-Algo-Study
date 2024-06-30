import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //최소 힙 문제 
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int token : scoville){
            q.add(token);   
        }
        int playTime = 0; //정답 출력용
        int tmp = 0; //임시 값 
        boolean canAnswer = false;
        tmp = q.peek();    //현재 큐에서 작은 놈을 찾는다.
        if(K<=tmp){
                canAnswer = true; //첫빵에 나올 수 있으니 함 거르고 시작
        }else{
            while(q.size()>1){
            playTime ++;
            int firstScoville = q.poll();
            int secondScoville = q.poll();
            int newScoville = firstScoville + (secondScoville*2);
            q.add(newScoville);
             tmp = q.peek();    //현재 큐에서 작은 놈을 넣는다.
            if(K<=tmp){
                canAnswer = true;
                break;
            }
        }
        }    
        
        if(canAnswer){
            answer = playTime;
        }else{
            answer = -1;
        }
        
        return answer;
    }
}
