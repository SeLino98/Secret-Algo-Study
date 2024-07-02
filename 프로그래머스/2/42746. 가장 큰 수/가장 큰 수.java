import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        //문자열로 변환한다.
        int arrSize = numbers.length;
        String[] numberList = new String[arrSize];
        
        for(int i=0; i<arrSize; i++){
            numberList[i] = String.valueOf(numbers[i]);
        }
        //변환된 문자열을 앞뒤 순으로 비교하는 구문을 넣고 비교한다. compareTo 
        Arrays.sort(numberList,(o1,o2) -> (o2+o1).compareTo(o1+o2)); // 내림차순
                                        //(o1+o2).compareTo 오름차순 
        
        
        //만약 0으로만 이뤄진 배열이 있으면 종료한다. 
        if(numberList[0].equals("0")) return "0";
        
        //StringBuilder를 이용해서 합친다. 
        StringBuilder sb = new StringBuilder();
        
        for(String token : numberList){
            sb.append(token);
        }
        answer = sb.toString();
        return answer;
    }
}