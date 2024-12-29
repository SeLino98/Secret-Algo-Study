import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
        // 길이가 N인 팰린드롬 문자열을 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        char [] arr = new char [num];

        Arrays.fill(arr, 'a');

        sb.append(arr);
        System.out.println(sb.toString());
    }
}