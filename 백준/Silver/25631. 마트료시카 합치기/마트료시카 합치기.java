import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int listSize = Integer.parseInt(br.readLine());
        int []list = new int[listSize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (listSize==1){
            System.out.print(1);
            return;
        }
        for (int i = 0; i < listSize; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int maxAnswer = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < listSize-1; i++) {
            if (list[i] == list[i+1]){
                count++;
            }else{
                count = 1;
            }
            maxAnswer = Math.max(maxAnswer,count);
        }
        System.out.print(maxAnswer);
    }
}
