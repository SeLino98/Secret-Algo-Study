class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] clear = new boolean[dungeons.length];
        return enter(k, dungeons, clear, 0);
    }
    
    public int enter(int k, int[][] dungeons, boolean[] clear, int count) {
        //count인자로 받아 몇번 했는지 누적 기록하기
        int maxCount = count;
        
        for(int i = 0; i < clear.length; i++) {
            //요구체력이 낮아 못가면 건너뛰기
            if(clear[i] || dungeons[i][0] > k) continue;
            clear[i] = true;
            //갈 수 있으면 지금 카운트랑 비교해서 큰거 고르기
            maxCount = Math.max(maxCount, enter(k - dungeons[i][1], dungeons, clear, count + 1));
            clear[i] = false;
        }
        
        return maxCount;
    }
}