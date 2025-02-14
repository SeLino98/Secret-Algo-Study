import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int t = 0; t < testCase; t++) {
            int token = Integer.parseInt(br.readLine());
            if (token == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else{
                pq.add(token);
            }
        }
        System.out.print(sb);
    }
}
