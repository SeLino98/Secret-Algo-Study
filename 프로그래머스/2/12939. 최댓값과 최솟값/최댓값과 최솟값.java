import java.util.*;
import java.io.*;
class Solution {
    public String solution(String s) {
        
        String [] list = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String token : list){
            int value = Integer.parseInt(token);
            max = Math.max(max,value);
            min = Math.min(min,value);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        String answer = sb.toString();
        return answer;
    }
}