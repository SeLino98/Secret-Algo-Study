import java.io.*;
import java.util.*;
public class Main {
    static int quarter,dime,nickel,penny = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int tmp = Integer.parseInt(br.readLine());
            //25 /10 /5 /1
            quarter = tmp/25;
            tmp = tmp%25;
            dime = tmp/10;
            tmp = tmp%10;
            nickel = tmp/5;
            tmp = tmp%5;
            penny = tmp;
            sb.append(quarter).append(" ").append(dime).append(" ")
                    .append(nickel).append(" ").append(penny).append('\n');
        }
        System.out.print(sb);
    }
}