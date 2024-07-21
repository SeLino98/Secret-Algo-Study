import java.util.*;
class Solution {
    public int solution(String name) {
int n = name.length();
        int answer = 0;
        int move = n - 1;  // 커서를 최악의 경우(오른쪽 끝까지)로 초기화

        for (int i = 0; i < n; i++) {
            // 현재 문자를 'A'로 변경하는 데 필요한 조작 횟수를 더함
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 다음 'A'가 아닌 문자의 위치를 찾음
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            // 커서 이동 최소 경로 계산
            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }

        answer += move;
        return answer;
    }
}
