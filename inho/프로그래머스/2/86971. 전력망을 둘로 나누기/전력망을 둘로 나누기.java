import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> wiresList;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        //양방향 연결을 한다.
        int rowSize = wires.length;
        wiresList = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            wiresList.add(new ArrayList<>());
        }


        for (int[] wire : wires) {
            int firstPos = wire[0];
            int secondPos = wire[1];
            wiresList.get(firstPos).add(secondPos);
            wiresList.get(secondPos).add(firstPos);
        }
        //경우의 수를 wires의 하나의 조건씩 마다 뺀다.
        //boolean으로 처리
        // boolean [] isChecked = new boolean[rowSize];
        for(int i =0; i < rowSize; i++){
            int firstPos = wires[i][0];
            int secondPos = wires[i][1];
            wiresList.get(firstPos).remove(Integer.valueOf(secondPos));
            wiresList.get(secondPos).remove(Integer.valueOf(firstPos));

            //노드를 삭제했다가, 노드를 추가하자.
            isVisited = new boolean[n+1];
            int test1 = BFS(firstPos);
            int test2 = BFS(secondPos);
            int result = Math.abs(test1-test2);
            answer = Math.min(result,answer);

            //i번째의 첫 값을 BFS로 돌린다.
            //i번째의 두 번째 값을 BFS로 돌린다.
            //계산된 깊이 값의 차이를 갱신한다.
            //다시 추가한다.
            wiresList.get(firstPos).add(secondPos);
            wiresList.get(secondPos).add(firstPos);
        }
        return answer;
    }
    static boolean []isVisited;
    public int BFS(int number){
        Queue<Integer> q = new LinkedList<>();
        q.add(number);
        int count = 1;
        isVisited[number] = true;
        while(!q.isEmpty()){
            int curPos = q.poll();
            for(int token : wiresList.get(curPos)){
                if(isVisited[token]) continue;
                isVisited[token] = true;
                count++;
                q.add(token);
            }
        }
        return count;
    }
}