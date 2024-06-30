import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> temp = new LinkedList<>();
        //한글자씩 큐에 넣기
        for (char c : s.toCharArray()) {
            temp.add(c);
        }
        //여는 괄호 갯수 샐 변수 지정
        int openCount = 0;
        while (!temp.isEmpty()) {
            char now = temp.poll();
            //(이면 갯수 증가
            if (now == '(') {
                openCount++;
            } else {
                //)일 때 (의 갯수가 없으면 올바르지 않아 false리턴
                if (openCount == 0) {
                    answer = false;
                    return answer;
                } else {
                    openCount--;
                } 
            } 
        }
        // 여는괄호가 남았으면 false
        if (openCount > 0) {
            answer = false;
        }
        return answer;
    }
}