class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        //제곱근까지 순회
        for(int i=1; i<=(int) Math.sqrt(yellow); i++){
            //정수의 곱으로 나타낼 수 있으면
            if(yellow%i ==0){
                int temp = yellow/i;
                //총 크기를 구하고 노란색만큼 때면 갈색 갯수
                int total = (i+2)*(temp+2) - yellow;
                if(total == brown) {
                    //갈색전체갯수가 주어진 갈색 갯수와 같으면 
                    answer = new int[] {temp+2, i+2};
                    break;
                }
            }
        }
        return answer;
    }
}