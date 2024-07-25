import java.util.*;

class Solution {
    class Line {
        int start;
        int end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        //라인스위핑 기법을 적용하기 위해 정렬후 배열에 넣기
        List<Line> lines = new ArrayList<>();
        for(int[] route : routes) {
            lines.add(new Line(route[0],route[1]));
        }
        lines.sort((o1,o2)->{
            if(o1.start == o1.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        
        int start = lines.get(0).start;
        int end = lines.get(0).end;
        
        //라인스위핑 시작 시작점과 끝점을 바탕으로 로직 수성
        for(Line now : lines) {
            if(now.start> end) {
                start = now.start;
                end = now.end;
                answer++;
            }
            if(now.end< end){
                end = now.end;
            }
            
        }
        // 마지막 그룹에 대한 카메라 1대 추가
        answer++;
        
        return answer;
    }
}