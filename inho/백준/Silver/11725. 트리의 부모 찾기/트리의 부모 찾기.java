
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {

    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] parent;
    static int Answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        parent = new int[N+1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {//n+1만큼 저장 0번째는 빈 값.
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N - 1; i++) { //만큼 list에 저장,.
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            list.get(X).add(Y);
            list.get(Y).add(X); //양방향으로 저장해야 이동 가능.
        }
        DFS(1);

        for(int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void DFS(int node) {
        visited[node] = true;

        for(Integer child : list.get(node)) {
            if(!visited[child]) {
                parent[child] = node;
                DFS(child);
            }
        }
    }
}