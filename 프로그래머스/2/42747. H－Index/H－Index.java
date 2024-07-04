import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int arrSize = citations.length;

        int midSize = arrSize/2;
        int tmpVal = arrSize%2;
        if(tmpVal!=0) midSize++;

//        System.out.print(midSize+"midSize");

        Arrays.sort(citations);

        int midVal = citations[midSize]; //6나옴
        int totalCount = 0;
        int totalCount1 = 0;
        while(true){
            totalCount = 0;
            totalCount1 = 0;
            for(int i = 0; i<arrSize; i++){
                if(midVal<=citations[i]){
                    totalCount++; //4 
                }else{
                    totalCount1++; //4
                }
            }
            if(totalCount>=midVal && totalCount1 <= midVal){
                answer = midVal;
                break;
            }else{
                midVal--;
            }
        }
        return answer;
    }
}