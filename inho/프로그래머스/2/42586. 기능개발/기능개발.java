import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //큐야야약
        //큐로 다 넣는다.
        //수정해야되니까 List로 한다.
        int pSize = progresses.length;
        int []countList = new int[pSize];
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i<pSize; i++){
            int count = 0;
            while(progresses[i]  < 100){
                progresses[i] += speeds[i];
                count++;
            }
            countList[i] = count;
        }
        //answerList 에 갈겨 넣기 
        for(int i=0; i<pSize; i++){
            int returnTotalCount = 0;
            int movePoint = 0; 
            for(int j = i; j<pSize; j++){
                if(countList[i]>=countList[j]){
                    returnTotalCount ++;
                    movePoint = j;
                }else{
                    break;
                }
            }
            i = movePoint;
            answerList.add(returnTotalCount);
        }
        // for(Integer token : answerList){
        //     System.out.print(token+" ");
        // }
        int answerArrSize = answerList.size();
        int[] answer = new int[answerArrSize];
        for(int i=0; i<answerArrSize; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}