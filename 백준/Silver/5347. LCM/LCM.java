import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = getGcd(a,b);
            long lcm = ((long) a *b)/gcd;
            sb.append(lcm).append('\n');
        }
        System.out.print(sb);
    }

    static int getGcd(int n1, int n2){
        if (n1%n2 == 0){
            return n2;
        }
        return getGcd(n2,n1%n2);
    }
}