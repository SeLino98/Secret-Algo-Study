import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        int n = citations.length;
        int h = 0;
        
        for (int i = n - 1; i >= 0; i--) { // 역순으로 탐색하면서 조건에 맞을 때 마다 h증가
            if (citations[i] > h) { 
                h++;
            } else {
                break;
            }
        }
        
        return h;
    }
}
