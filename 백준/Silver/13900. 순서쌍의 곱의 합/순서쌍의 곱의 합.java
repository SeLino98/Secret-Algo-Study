import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int listSize = Integer.parseInt(br.readLine());

        long [] list = new long[listSize];
        long total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < listSize; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            total += list[i];
        }
        long answer = 0;
        for (int i = 0; i < listSize; i++) {
            total -= list[i];
            answer += list[i]*(total);
        }
        System.out.print(answer);
    }
}
