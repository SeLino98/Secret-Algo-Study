import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result1 = (A+B)%C;
        int result2 = ((A%C)+(B%C))%C;
        int result3 = (A*B)%C;
        int result4 = ((A%C)*(B%C))%C;

        StringBuilder sb = new StringBuilder();
        sb.append(result1).append("\n");
        sb.append(result2).append("\n");
        sb.append(result3).append("\n");
        sb.append(result4).append("\n");
        System.out.print(sb);
    }
}
