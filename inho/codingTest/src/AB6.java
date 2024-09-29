import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AB6 {
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
