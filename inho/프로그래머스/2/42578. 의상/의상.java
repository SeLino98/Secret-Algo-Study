import java.util.*;

class Solution {
    static int [] clothsList;
    public int solution(String[][] clothes) {
          HashMap<String,Integer> tmpHash = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String categoryKey = clothes[i][1]; //종류 넣는다.
            //같은 의상이 없으니 0번 고려 안해도 됨 .
            tmpHash.put(categoryKey, tmpHash.getOrDefault(categoryKey,0)+1);
        }
        clothsList = new int[tmpHash.size()];
        int tmpValue = 0;
        for (Integer tmpToken : tmpHash.values() ) {
            clothsList[tmpValue] = tmpToken;
            tmpValue++;
        }
        int tmpAnswer = 1;
        for (int i = 0; i < clothsList.length; i++) {
            tmpAnswer *= clothsList[i]+1;
        }
        int realAnswer = tmpAnswer-1;
        return realAnswer;
    }
    
    static int answer = 0;
    static boolean[] isVisited;
     static void combiFunction(int depth,int curDepth, int sum ){
        if (depth==curDepth){
            //깊이가 같다면? 종료
            answer += sum;
            return ;
        }
        for (int i = curDepth; i < clothsList.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            sum*=clothsList[i];
            combiFunction(depth,i+1,sum);
            sum/=clothsList[i];
            isVisited[i] = false;
        }
    }
}