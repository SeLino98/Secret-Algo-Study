import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] list = new int[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = i+1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second =Integer.parseInt(st.nextToken())-1;
            int tmp = list[first];
            list[first] = list[second];
            list[second] = tmp;
        }

        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
