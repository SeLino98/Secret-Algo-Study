
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int start;
    int end;
    int cost;

    public Node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static List<Node> edges = new ArrayList<>();
    static int[] unionFindList;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerN = Integer.parseInt(br.readLine());
        int canLineN = Integer.parseInt(br.readLine());
        unionFindList = new int[computerN + 1];

        for (int i = 1; i <= computerN; i++) {
            unionFindList[i] = i;
        }

        for (int i = 0; i < canLineN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(s, e, c));
        }

        // Sort edges based on cost
        Collections.sort(edges);

        for (Node edge : edges) {
            if (!isCycle(edge.start, edge.end)) {
                union(edge.start, edge.end);
                sum += edge.cost;
            }
        }

        System.out.println(sum);
    }

    static int find(int r) {
        if (r == unionFindList[r]) {
            return r;
        }
        return unionFindList[r] = find(unionFindList[r]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            unionFindList[y] = x;
        }
    }

    static boolean isCycle(int x, int y) {
        return find(x) == find(y);
    }
}
