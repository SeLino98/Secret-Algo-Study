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
            int maxAnswer = Integer.MIN_VALUE;
            for (int i = 0; i < arrSize; i++) {
                int tmpValue = 0;
                for (int j = i; j < arrSize; j++) {
                    if (j==i){
                        tmpValue = list[i];
                    }else{
                        tmpValue += list[j];
                    }
                    maxAnswer = Math.max(tmpValue,maxAnswer);
                }
            }
            //출력
            sb.append(maxAnswer).append('\n');
        }
        System.out.print(sb);
    }

}
