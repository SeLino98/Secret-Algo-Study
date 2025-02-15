import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        //큐로 다 넣는다.
        //특정 순서일 때 답에 넣고
        //특정 순서가 아닐 땐 큐에 다시 넣는다.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(i+1);
        }
        int point = 1;
        sb.append('<');
        while (!q.isEmpty()){
            int token = q.poll();
            if (point++%K==0){// k = 3
                sb.append(token);
                if (q.size()!=0){
                    sb.append(", ");
                }
            }else{
                q.add(token);
            }
        }
        sb.append('>');
        System.out.print(sb);
    }
}
