import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        // 두 점 조합의 기울기를 비교하여 평행 확인
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;

        return 0;
    }

    // 두 직선의 기울기가 같은지 확인
    private boolean isParallel(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        int x1 = dot1[0] - dot2[0];
        int y1 = dot1[1] - dot2[1];
        int x2 = dot3[0] - dot4[0];
        int y2 = dot3[1] - dot4[1];

        // 기울기 비교: (y1/x1) == (y2/x2) → y1 * x2 == y2 * x1
        return y1 * x2 == y2 * x1;
    }
}
