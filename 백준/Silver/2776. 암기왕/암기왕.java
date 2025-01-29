import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int testCase;
    public static void main(String[] args) throws IOException{
        testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            HashSet<Integer> set = new HashSet<>();
            int page1 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < page1; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int page2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < page2; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (set.contains(tmp)){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
