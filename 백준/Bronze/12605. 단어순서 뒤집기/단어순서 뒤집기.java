import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= testCase; t++) {
            String tmp = br.readLine();
            String [] tmpList = tmp.split(" ");
            sb.append("Case ").append("#").append(t).append(": ");
            for (int i = tmpList.length-1; i >= 0 ; i--) {
                sb.append(tmpList[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
