package phonebook;

import java.util.Arrays;

public class Solution {
    // 전화번호 목록을 입력받아 특정 조건을 확인한 후 true 또는 false를 반환하는 메서드
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int len = phone_book.length;

        for (int i = 0; i < len - 1; i++) {
            String prefix = phone_book[i];
            String next = phone_book[i + 1];
            // startsWith은 문자열이 특정 문자열로 시작하는지 확인하는 메서드
            // 지정된 접두사로 시작하면 true, 그렇지 않으면 false를 반환
            if (next.startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }

    // 프로그램 실행을 위한 메인 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 테스트를 위한 전화번호 목록
        String[] phone_book = {"12","123","1235","567","88"};

        // solution 메서드 호출 및 결과 출력
        boolean result = sol.solution(phone_book);
        System.out.println("Result: " + result);
    }
}
