import java.util.*;
import java.io.*;
class Solution {
    public boolean solution(String[] phone_book) {
        //정답을 true로 default 설정한다.
        boolean answer = true;
        
        //사이즈 선언한다
        int arrSize = phone_book.length-1;
        
        //문자열 길이로 정렬한다. 
        Arrays.sort(phone_book);
        
        //for문 돌면서 해당 값으로 문자가 시작하는지 체크한다.
        // 하나라도 걸리면 false를 리턴하고 바로 종료
        for(int i = 0 ; i< arrSize; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        //중복값이 없는 경우니 true 리턴
        return answer;
    }
}