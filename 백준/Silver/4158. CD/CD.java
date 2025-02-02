import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{

        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N==0&&M==0)break;
            HashSet<Integer> set = new HashSet<>();
            int answer = 0 ;
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }
            for (int i = 0; i < M; i++) {
                if (set.contains(Integer.parseInt(br.readLine()))) answer++ ;
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
