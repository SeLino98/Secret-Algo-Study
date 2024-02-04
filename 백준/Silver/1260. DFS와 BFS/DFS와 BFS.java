import java.util.*;

class Main {
    static int m;
    static int [] chk;
    static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         m = sc.nextInt();
        int v = sc.nextInt();
        chk = new int[n+1];
        Arrays.fill(chk,0);
        arr = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr.get(start).add(end);
            arr.get(end).add(start);
        }
        for (int i = 1; i < n+1; i++) {
            Collections.sort(arr.get(i));
        }
        DFS(v);
        System.out.println();
        Arrays.fill(chk,0);
        BFS(v);
    }
    public static void DFS(int v){
        chk[v] = 1;
        System.out.print(v + " ");
        for (int i = 0; i < arr.get(v).size(); i++) {
            int next = arr.get(v).get(i);
            if(chk[next]==0){
                DFS(next);
            }
        }
    }
    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        chk[v] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for(int i = 0; i < arr.get(cur).size(); i++) {
                int next = arr.get(cur).get(i);
                if(chk[next] == 0) {
                    q.add(next);
                    chk[next] = 1;
                }
            }
        }
    }

}