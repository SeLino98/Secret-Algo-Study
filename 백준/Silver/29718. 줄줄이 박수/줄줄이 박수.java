import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int [] map = new int[colSize];

        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                map[j] += Integer.parseInt(st.nextToken());
            }
        }
        if (colSize==1) {
            System.out.print(map[0]);
            return;
        }
        int range = Integer.parseInt(br.readLine());
        int curTotalClap = 0;
        for (int i = 0; i < range; i++) {
            curTotalClap += map[i];
        }
        int answer = curTotalClap;
        for (int i = 0; i < colSize-range; i++) {
            curTotalClap = curTotalClap + map[range+i] - map[i];
            answer = Math.max(answer,curTotalClap);
        }
        System.out.print(answer);
    }
}
