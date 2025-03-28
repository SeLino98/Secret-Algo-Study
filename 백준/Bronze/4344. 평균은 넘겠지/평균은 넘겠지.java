import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int personCount = Integer.parseInt(st.nextToken());
            int avg = 0;

            int [] list = new int[personCount];
            for (int i = 0; i < personCount; i++) {
                int token = Integer.parseInt(st.nextToken());
                avg += token;
                list[i] = token;
            }

            avg /= personCount;
            int cnt = 0;
            for (int i = 0; i < personCount; i++) {
                if (list[i]>avg){
                    cnt++;
                }
            }
//            double answer = Math.round((float)cnt/personCount*100000) / 1000.0 ;
            String answer = String.format("%.3f",(float)cnt/personCount*100);
            sb.append(answer).append("%").append('\n');
        }
        System.out.print(sb);
    }
}
