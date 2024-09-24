import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            answer.append(br.readLine());
        }
        char [] list = answer.toString().toCharArray();

        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for (char tmp: list
             ) {
            sb.append(tmp);
        }
        System.out.println(sb);
    }
}
