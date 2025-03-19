import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int personCount = Integer.parseInt(br.readLine());
            int maxValue = Integer.MIN_VALUE;
            String maxPerson = "";
            for (int i = 0; i < personCount; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                if (value>maxValue){
                    maxValue = value;
                    maxPerson = name;
                }
            }
            sb.append(maxPerson).append('\n');
        }
        System.out.print(sb);
    }
}
