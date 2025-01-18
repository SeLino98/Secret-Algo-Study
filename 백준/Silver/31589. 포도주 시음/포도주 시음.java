import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long []list = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(list);
        long answer = list[N-1];
        int lt = 0 ;
        int rt = N-2;
        int count = K-1;
        while (count>1){
            answer += list[rt--] - list[lt++];
            count -= 2;
        }
        System.out.print(answer);
    }

}
