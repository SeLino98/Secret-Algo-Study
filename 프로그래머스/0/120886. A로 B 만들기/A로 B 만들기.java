import java.util.*;
import java.io.*;
class Solution {
        public int solution(String before, String after) {
            int answer = 1;
            if(before.length() != after.length() ) return 0;
            HashMap<Character,Integer> hashMap = new LinkedHashMap<>();
            
            for(char token : before.toCharArray()){
                if(hashMap.containsKey(token)){
                    int value = hashMap.get(token);
                    hashMap.remove(token);
                    hashMap.put(token,value+1);
                }else{
                    hashMap.put(token,1);
                }
            }

            for(char token : after.toCharArray()){
                if(hashMap.containsKey(token)){
                    //값이 있을 때 
                    //더 많이 요구할 때       
                    int value = hashMap.get(token);
                    if(value<=0) return 0;
                    hashMap.remove(token);
                    hashMap.put(token,value-1);
                }else{//값이 없을 때 
                    return 0;
                }
            }
            return answer;
        }
    }