import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int k,answer;
    static int[]list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
         answer = Integer.MIN_VALUE;
        list = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
           list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        DFS(0);
        System.out.println(answer);
    }
    static void DFS(int n){
        if (N<n) return;
        if(answer<n) {
            answer = n;
        }
        for (int i = k-1; i >= 0; i--) {
            DFS(n*10+list[i]);
        }
    }
}
