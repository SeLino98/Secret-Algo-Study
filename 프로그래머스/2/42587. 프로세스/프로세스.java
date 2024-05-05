import java.util.*;
public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> answerList = new ArrayList<>();
        ArrayList<int[]> list = new ArrayList<>();
        for(int i =0; i < priorities.length; i++){ //0번쨰 배열은 priorities의 값, 1번째 배열은 순서
            list.add(new int[]{priorities[i],i});
        }
        while(list.size() != 0){
            int[] temp = list.get(0);
            boolean isPrior = true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0]>temp[0]) {
                    list.add(temp);
                    list.remove(0);
                    isPrior = false;
                    break;
                }
            }
            if (isPrior){
                answerList.add(temp[1]);
                list.remove(0);
            }
        }
        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i)==location){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}