import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int[] parent;
    static int N,M;
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    parent = new int[N];
    for (int i = 0; i < parent.length; i++) {
        parent[i] = i;
    }
    int answer = 0;
    for (int i = 1; i <= M; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (union(x, y)) {
			answer = i; 
			break;
		}
    }
    System.out.println(answer);
}
static int find(int x){
    if (parent[x] == x){
        return x;
    }
    return parent[x] = find(parent[x]);
}
static boolean union(int x, int y){
    int a = find(x);
    int b = find(y);
    
    if(a==b){
    	return true; 
    }
    parent[b] = a;
    return false;
}
}