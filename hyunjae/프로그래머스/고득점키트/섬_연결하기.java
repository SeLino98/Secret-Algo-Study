import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        //최소신장트리문제
        int answer = 0;
        //정렬한 후
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2],o2[2]));
        //유니온파인드할 배열 만들기
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        //각각 돌면서 조상이 다르면 연결이 안된것이므로 비용 더하고 유니온연결하기
        for(int[] edge : costs) {
            int u = edge[0];
            int v = edge[1];
            if(find(u,parent) != find(v,parent)) {
                answer += edge[2];
                union(u,v,parent);
            }
        }
        return answer;
    }
    
    //작은수가 부모가 되게 유니온 하기
    public boolean union(int x, int y, int[] parent){
        x = find(x, parent);
        y = find(y, parent);
        if(x == y) return false;
        
        parent[Math.max(x,y)] = Math.min(x,y);
        return true;
    }
    
    
    //루트노드 찾기
    public int find(int x, int[] parent) {
        if(parent[x] ==x ) return x;
        int rootNode = find(parent[x], parent);
        parent[x] = rootNode;
        return rootNode;
    }
}