import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            // 가장 가벼운 사람과 가장 무거운 사람의 합이 limit 이하일 경우
            if (people[i] + people[j] <= limit) {
                i++; // 가벼운 사람 태우기
            }
            // 가장 무거운 사람은 항상 태우기
            j--;
            answer++; // 보트 수 증가
        }

        return answer;
    }
}