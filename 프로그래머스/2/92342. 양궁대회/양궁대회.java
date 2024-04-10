class Solution {

    public int[] solution(int n, int[] info) {
        answerList = new int[11];
        //이길 경우 구하기
        //커질 때까지 값을 주고, 깊이가 n이 되면 계산.
        //큰값 answer로 저장
        maxValue = 0;
        isVisited = new boolean[11];
        int[] result = new int[11];
        //차이점수 계산 result에 따라
        int depth = 0;
        combination(depth,n,info,result);
        if(maxValue== 0){
            return new int[]{-1};
        }
        return answerList;

    }
    static int maxValue;
    static boolean[] isVisited;
    static int[] answerList ;
    int calMaxValue(int[] info ,int[] result){
        int value = 0; //라이언 점수
        int aphValue = 0; //아파치 점수
        for(int i=0; i<11; i++){
            if(info[i]<result[i]){ //라이언이 이긴 경우
                //큰 값 계산
                value += 10 -i ;
            }else {
                if(info[i]!=0){  //아파치가 이긴 경우
                    aphValue += 10-i;
                }
            }
        }
        if(aphValue<value){
            return value - aphValue;
        }else{
            return -1;
        }
    }
    static int[] testList = new int[]{1,1,1,1,1,1,1,1,0,0,2};
    void combination(int depth,int n, int[] info, int[] result){
        if (0==n){
            int value = calMaxValue(info, result);
            if(maxValue<=value){  //계산식
                maxValue = value;
                // System.out.println(maxValue);
                answerList = result.clone();
            }
//            boolean flag = true;
//            for (int i = 0; i < 11; i++) {
//                if (result[i]!=testList[i]){
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) System.out.println(value+" : ");
//             for (int i = 0; i < result.length; i++) {
//                 System.out.print(result[i]+" ");
//             }
//             System.out.println();
            return;
        }
        for (int i = 0; i < info.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            if(info[i]<n){
                // 클 경우 채우고 넘겨
                int value = info[i] + 1;
                result[i] = value;
                combination(depth+1,n-value,info,result);
                result[i] -= value;
            }else{//n이 작을 경우.. 못 채워
                if (n>0&&i==10){
                    result[i] = n;
                    combination(depth+1,0,info,result);
                    result[i] -= n;
                }else{
                    combination(depth+1,n,info,result);
                }
            }
            isVisited[i] = false;
        }
    }
}