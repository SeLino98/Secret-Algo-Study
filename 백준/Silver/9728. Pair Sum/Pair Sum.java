import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int listCount = Integer.parseInt(st.nextToken());
            int targetSum = Integer.parseInt(st.nextToken());
            int [] list = new int[listCount];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < listCount; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list);
            int answer = 0;
            int lt = 0;
            int rt = list.length-1;
            while (lt<rt){
                int tmpSum = list[lt]+list[rt];
                if (tmpSum<targetSum){
                    lt++;
                }else if(tmpSum>targetSum){
                    rt--;
                }else{
                    lt++;
                    answer++;
                }
            }
            sb.append("Case #").append(i).append(": ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
