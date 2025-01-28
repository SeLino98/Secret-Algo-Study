import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s, int n) {
        //값입력 받으면 char로 아스키 코드 값 n만큼 증가 시키기
        //붙어 있는 경우
        char [] list = s.toCharArray();
        //공백으로 된 경우 제거 
        StringBuilder sb = new StringBuilder();
        for(char token : list){
            if(token == ' ') {
                sb.append(" ");
            }else if(Character.isUpperCase(token)){
                sb.append((char)((token - 'A' + n )%26 +'A'));
            }else if(Character.isLowerCase(token)){
                sb.append((char)((token - 'a' + n )%26 +'a'));
            }
        }
        return sb.toString();
    }
}