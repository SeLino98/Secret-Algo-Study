import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int listSize = Integer.parseInt(st.nextToken());
        int [] list = new int[listSize+1];
        int findValue = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < listSize; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int answerSize = Integer.MAX_VALUE;
        int sum = list[0];
        int lt = 0;
        int rt = 1;
        //커지면 S보다 작아질때까지 lt++;
        //S보다 작으면 rt ++ 누적합하여 같거나 커질 때까지
        while (rt<list.length){
            if (findValue<=sum){
                sum -= list[lt];
                answerSize = Math.min(answerSize,rt-lt);
                lt++;
            }else{
                sum += list[rt];
                rt++;
            }
            if (lt>=rt) rt++;
            if (answerSize==1) break;
        }

        if (answerSize == Integer.MAX_VALUE){
            System.out.print(0);
        }else{
            System.out.print(answerSize);
        }
    }
}
