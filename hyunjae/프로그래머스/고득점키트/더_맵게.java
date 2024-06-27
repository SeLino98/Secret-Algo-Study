import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> a = new PriorityQueue<>();

        for (int s : scoville) {
            a.offer(s);
        }

        //스코빌지수 이하일 때 까지만 반복
        while(a.peek()<K) {
            //하나만 남았으면 스코빌 지수를 K이상으로 만들 수 없는 경우 -1반환
            if(a.size()==1){
                return -1;
            }
            int scv = a.poll()+a.poll()*2;
            answer +=1;
            a.offer(scv);
        }
 
        //반복문이 멈췄으면 성공한 경우니 횟수 반환
        return answer;
    }
}