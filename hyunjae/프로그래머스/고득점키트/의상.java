import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        //카운트할 해쉬맵생성
        Map<String, Integer> clothesCount = new HashMap<>();
        //의상종류가 이미 해쉬맵에 있으면 +1 없으면 2로 시작
        //2로시작하는 이유는 종류에 옷이 1개라도 있으면 그거 입는다, 안입는다 선택지가 2개기 때문
        for (String[] cloth : clothes) {
            String kind = cloth[1];
            clothesCount.put(kind, clothesCount.getOrDefault(kind, 1) + 1);
        }

        //조합할 수 1로 놔두기 0말고 1로하는 이유 곱하기 하기 위해
        int combinations = 1;
        // 각 해쉬맵을 돌면서 밸류값 곱하기
        for (int count : clothesCount.values()) {
            combinations *= count;
        }

        // 다 안입는 경우는 빼야하니 -1
        return combinations - 1;
    }
}