import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String,Integer> map = new LinkedHashMap<>();
            for(String token : participant){
                if (map.containsKey(token)){
                    int countUp = map.get(token);
                    map.remove(token);
                    map.put(token,countUp+1);
                }else{
                    map.put(token,1);
                }
            }

            for(String token : completion ){
                if(map.containsKey(token)){ // 명단에 있다면
                    int dupPersonCount = map.get(token);
                    if(dupPersonCount > 1){
                        map.remove(token);
                        map.put(token,dupPersonCount-1);
                    }else if (dupPersonCount==1){//1과 같거나 작으면
                        map.remove(token);
                    }else{
                        return token;
                    }
                }else{ //없다면 해당 값 저장
                    return token;
                }
            }
            ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
            answer = list.get(0).getKey();
            return answer;
        }
}