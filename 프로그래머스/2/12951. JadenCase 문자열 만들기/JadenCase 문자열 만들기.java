import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char [] list = s.toCharArray();
        
        boolean isFirst = true; 
        int pos = 0;
        for(int i = 0; i<list.length; i++){
            list[i] = Character.toLowerCase(list[i]);
        }
        for(int i = 0; i<list.length; i++){
            if(list[i]==' '||isFirst){
                pos = i;
                if(isFirst){
                    list[pos] = Character.toUpperCase(list[pos]);
                    isFirst = false;
                }
                while(pos<list.length){
                    if(list[pos]!=' '){
                        list[pos] = Character.toUpperCase(list[pos]);
                        break;
                    }             
                    pos++;
                }
                i = pos;
            }
        }
        for(char token : list){
            sb.append(token);
        }
        answer = sb.toString();
        return answer;
    }
}