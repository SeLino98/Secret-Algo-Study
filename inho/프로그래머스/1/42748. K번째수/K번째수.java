import java.util.*; 
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int commandsRowSize = commands.length;
        int[] answer = new int[commandsRowSize];
        int[] tempList;
        //commands의 순서대로 i j k 이라고 하면, 
        // i부터 j까지 자르고 정렬 후 k를 출력한다. 
        for(int t = 0; t<commandsRowSize; t++){
            int i = commands[t][0]-1;
            int j = commands[t][1]-1;
            int k = commands[t][2]-1;
            tempList = new int[j-i+1];
            for(int z = i; z<=j; z++){
                tempList[z-i] = array[z];
            }
            Arrays.sort(tempList);
            answer[t] = tempList[k];
        }
        //commands의 length만큼 for문을 돌린다. 
        return answer;
    }
}