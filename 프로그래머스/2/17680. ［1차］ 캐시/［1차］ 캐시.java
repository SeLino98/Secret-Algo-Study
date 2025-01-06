import java.util.*;
class Solution { //프로그래머스 [1차]캐시 카카오 블라인드
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize==0) return cities.length*5;
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < cities.length; i++) {
            String tmpName = cities[i].toLowerCase();
            if (deque.size()<cacheSize){//큐가 캐시사이즈값보다 작은 경우
                if (deque.contains(tmpName)){//새로 들어온 값을 이미 갖고 있는 경우
                    deque.remove(tmpName);// 그 값을 제거.
                    deque.offerLast(tmpName); //
                    answer+=1;
                }else{
                    deque.offerLast(tmpName);
                    answer += 5;
                }

            }else{
                if (deque.contains(tmpName)){//값이 있는 경우
                    deque.remove(tmpName);// 그 값을 제거.
                    deque.offerLast(tmpName); //
                    answer+=1;
                }else{//값이 없는 경우
                    deque.pollFirst();
                    deque.offerLast(tmpName);
                    answer+=5;
                }
            }
        }
        return answer;
    }
}