import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append("Case #").append(t).append(": ").append(a).append(" + ").append(b).append(" = ").append(a+b);
            sb.append("\n");
        }
        System.out.print(sb);

    }

}
