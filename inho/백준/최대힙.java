import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {return o2-o1;});
        StringBuilder sb =new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            int num = Integer.parseInt(br.readLine());
            if (num==0){
                //큐가 비었을 때
                if (q.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    int tmp = q.poll();
                    sb.append(tmp).append('\n');
                }
                //비어있지 않앗을 떄
            }else{
                q.add(num);
            }
        }
        System.out.println(sb.toString());
    }
}