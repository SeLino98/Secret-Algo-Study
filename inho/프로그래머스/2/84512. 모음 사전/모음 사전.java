import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        wordToken = new ArrayList<>();
        sb = new StringBuilder();
        char [] charWordList;
        for(int d = 1; d<=wordList.length; d++){
            charWordList = new char[d];
            combination(0,charWordList,d);
        }
        Collections.sort(wordToken);
        for (int t = 0; t < wordToken.size(); t++) {
            if (wordToken.get(t).equals(word)) {
                answer = t+1;
                break;
            }
        }
        return answer;
    }
    static ArrayList<String> wordToken;
    static StringBuilder sb = new StringBuilder();
    static final char [] wordList = {'A','E','I','O','U'};
    static void combination(int depth, char[] charList , int endDepth){
        if(depth == endDepth){
            for (int i = 0; i < charList.length; i++) {
                sb.append(charList[i]);
            }
            wordToken.add(sb.toString());
            sb.setLength(0);
            return;
        }
        for(int i = 0; i < wordList.length; i++){
            charList[depth] = (wordList[i]);
            combination(depth+1,charList,endDepth);
        }
    }
}