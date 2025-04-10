import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int faultIdx = Integer.parseInt(st.nextToken())-1;
            char [] list = st.nextToken().toCharArray();
            for (int i = 0; i < list.length; i++) {
                if (faultIdx!=i) sb.append(list[i]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
