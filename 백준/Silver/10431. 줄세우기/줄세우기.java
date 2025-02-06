import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int []list = new int[20];
            int caseNum = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 20; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 1; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (list[i]<list[j]){
                        count++;
                        int tmp = list[i];
                        list[i] = list[j];
                        list[j] = tmp;
                    }
                }
            }
            sb.append(caseNum).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
    }
}
