import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            //입력
            int arrSize = Integer.parseInt(br.readLine());
            int [] list = new int[arrSize];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < list.length; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            //계산
            int curMaxValue = list[0];
            int answerMaxValue = list[0];
            for (int i = 1; i < arrSize; i++) {
                curMaxValue = Math.max(list[i],curMaxValue+list[i]);
                answerMaxValue = Math.max(curMaxValue,answerMaxValue);
            }
            //출력
            sb.append(answerMaxValue).append('\n');
        }
        System.out.print(sb);
    }

}
