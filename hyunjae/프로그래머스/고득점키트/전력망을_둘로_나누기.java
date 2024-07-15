import java.util.*;

class Solution {
    private int count;  // 멤버 변수로 count 선언
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 그래프 초기화
        Set<Integer>[] graph = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        
        // 그래프에 길 추가
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        // 각 길을 제거하고 두 개의 서브 그래프 크기 차이를 계산
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 길 제거
            graph[v1].remove(v2);
            graph[v2].remove(v1);
            
            // 서브 그래프 크기 계산
            count = 0;
            boolean[] visited = new boolean[n + 1];
            dfs(v1, graph, visited);
            
            int size1 = count;
            int size2 = n - size1;
            answer = Math.min(answer, Math.abs(size1 - size2));
            
            // 길 다시 복원
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    private void dfs(int node, Set<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        count++;
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
