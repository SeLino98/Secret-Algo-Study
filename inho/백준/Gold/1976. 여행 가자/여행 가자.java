import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main{
    static int[]parent;
    static int N,M;
    static boolean[] isConnected;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isConnected = new boolean[N+1];
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n==1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int num = 1;
        int startNum = st.countTokens();
        int[] travelList = new int[startNum+1];
        while(startNum-->0){
            int N = Integer.parseInt(st.nextToken());
            travelList[num] = find(N);
            num++;
        }
        boolean isAnswer = true;
        for (int i = 1; i < travelList.length-1 ; i++) {
            if (travelList[i]!=travelList[i+1]){
                isAnswer = false;
                break;
            }
        }
        if (isAnswer){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
