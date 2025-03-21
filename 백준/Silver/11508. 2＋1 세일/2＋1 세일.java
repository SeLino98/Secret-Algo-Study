import java.io.*;
import java.util.*;
public class Main{
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int stuffCount = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < stuffCount; i++) {
            int value = Integer.parseInt(br.readLine());
            q.add(value);
        }
        int p = 1;
        int answer = 0;
        while (!q.isEmpty()){
            if (p%3!=0){
                answer += q.poll();
            }else{
                q.poll();
            }
            p++;
        }
        System.out.print(answer);
    }
}
