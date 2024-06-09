import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] list ;
    static int[] answer ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        answer = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
        comBi(0,0);
        System.out.println(sb);
    }

    static void comBi(int start, int depth){
        if(depth == m){
            for (int token: answer) {
                sb.append(token).append(" ");
            }
            sb.append("\n");
            return;
        }
        int backNum = -1;
        for (int i = start; i < n; i++) {
            if (backNum!=list[i]){
                answer[depth] = list[i];
                backNum = list[i];
                comBi(i,depth+1);
            }
        }

    }
}
