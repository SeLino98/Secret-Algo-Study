import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //백만이면,,
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int token : scoville){
            q.add(token);   
        }
        int playTime = 0;
        int tmp = 0;
        boolean canAnswer = false;
        tmp = q.peek();    //현재 큐에서 작은 놈을 넣는다.
            // System.out.println(tmp+"::"+playTime);
        if(K<=tmp){
                canAnswer = true;
        }else{
            while(q.size()>1){
            playTime ++;
            int firstScoville = q.poll();
            int secondScoville = q.poll();
            int newScoville = firstScoville + (secondScoville*2);
            q.add(newScoville);
             tmp = q.peek();    //현재 큐에서 작은 놈을 넣는다.
            // System.out.println(tmp+"::"+playTime);
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
