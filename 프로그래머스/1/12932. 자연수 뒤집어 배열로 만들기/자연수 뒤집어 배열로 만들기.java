import java.util.*;
class Solution {
    public int[] solution(long n) {
        long token = 0 ;
        long power = 10;
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            if(n==0) break;
            token = n%power;
            n = n/power;
            list.add((int) (token));
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i< answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}