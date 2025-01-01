import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = "";
        StringBuilder sb = new StringBuilder();
        while((S = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(S);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int max = Math.max((B - A), (C - B))-1;
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

}