import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        while (true){
            StringBuilder tmpSb = new StringBuilder();
            String token = br.readLine();
            if (token.equals("END")) break;
            tmpSb.append(token);
            tmpSb.reverse();
            sb.append(tmpSb).append('\n');
        }
        System.out.print(sb);
    }
}
