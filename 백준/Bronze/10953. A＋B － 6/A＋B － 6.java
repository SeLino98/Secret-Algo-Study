import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char [] tmpList;
        for (int t = 0; t < testCase; t++) {
            tmpList = br.readLine().toCharArray();
            int total = tmpList[0]+tmpList[2]-96;
            sb.append(total).append('\n');
        }
        System.out.print(sb);
    }
}
