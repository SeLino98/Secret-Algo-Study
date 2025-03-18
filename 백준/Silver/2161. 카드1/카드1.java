import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int value = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= value; i++) {
            q.add(i);
        }
        while(q.size()>=1){
            sb.append(q.poll()).append(" ");
            if (q.size()<1) break;
            int tmp = q.poll();
            q.offerLast(tmp);
        }
        System.out.print(sb.toString().trim());
    }
}
