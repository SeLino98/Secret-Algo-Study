import java.util.*;
import java.io.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] wordList = my_string.toCharArray();
        Set<Character> set = new HashSet<>();
        
        for(char token : wordList ){
            if(set.contains(token)) continue;
            sb.append(token);
            set.add(token);
        }
        return sb.toString();
    }
}