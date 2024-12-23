import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int listSize = Integer.parseInt(br.readLine());
        int []list=  new int[listSize+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < list.length; i++) {//구간합 리스트 저장하기
            int tmp = Integer.parseInt(st.nextToken());
            list[i] = tmp+list[i-1];
        }
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int partOfanswer = list[s] - list[f-1];
            sb.append(partOfanswer).append('\n');
        }
        System.out.print(sb);
    }
}
