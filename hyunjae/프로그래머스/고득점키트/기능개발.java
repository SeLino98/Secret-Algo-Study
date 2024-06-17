import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        //정답 담을 리스트 생성
        List<Integer> tempAnswer = new ArrayList<>();
        int n = progresses.length;
        int[] days = new int[n];

        // 각 기능이 완료되기까지 필요한 일수 계산
        for (int i = 0; i < n; i++) {
            int remainingWork = 100 - progresses[i];
            days[i] = (remainingWork + speeds[i] - 1) / speeds[i]; // 올림 처리
        }

        //첫 작업이 끝날 때를 시작 값으로 지정
        int currentDay = days[0];
        //첫 작업 1개가 무조건 들어가므로 1로지정
        int count = 1;

        // 기능 배포 처리
        for (int i = 1; i < n; i++) {
            if (days[i] <= currentDay) {
                count++;
            } else {
                tempAnswer.add(count);
                currentDay = days[i];
                count = 1;
            }
        }
        tempAnswer.add(count);

        // 결과 배열로 변환
        int[] answer = new int[tempAnswer.size()];
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;
    }
}