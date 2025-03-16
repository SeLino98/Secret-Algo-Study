import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        int value = Integer.parseInt(br.readLine());
        int mox = value/4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mox; i++) {
            sb.append("long").append(" ");
        }
        sb.append("int");
        System.out.print(sb.toString().trim());
    }
}
