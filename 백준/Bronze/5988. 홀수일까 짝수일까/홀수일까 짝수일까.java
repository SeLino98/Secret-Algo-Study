import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            String token = br.readLine();
            int value = token.charAt(token.length()-1);
            if (value%2==0){
                sb.append("even");
            }else{
                sb.append("odd");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
