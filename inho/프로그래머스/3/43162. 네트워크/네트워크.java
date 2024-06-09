import java.util.*;
class Solution {
    static boolean []isVisited ;
    static int[][] map;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int size = computers.length;
        isVisited = new boolean[size];
        map = computers;
        for (int i = 0; i < computers.length; i++) {
            if (!isVisited[i]){
                DFS(i);
                answer++;
            }
        }

        return answer;
    }
    static void DFS(int i){
        isVisited[i] = true;
        for (int j = 0; j < map.length ; j++) {
            if (i==j) continue;
            if (map[i][j]==1&&(!isVisited[j])){
                isVisited[j] = true;
                DFS(j);
            }
        }
    }

}