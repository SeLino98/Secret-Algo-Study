import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> q =  new PriorityQueue<>((o1,o2)->o2-o1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                q.add(n);
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = q.poll();
        }
        System.out.println(answer);
    }
}
