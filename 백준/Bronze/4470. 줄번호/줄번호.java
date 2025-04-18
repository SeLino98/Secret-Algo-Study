import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            String tmp = br.readLine();
            sb.append(t).append(". ").append(tmp).append('\n');
        }
        System.out.print(sb);
    }
}