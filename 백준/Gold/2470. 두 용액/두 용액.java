import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int []list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stringSize = Integer.parseInt(br.readLine());
        list = new int[stringSize];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < stringSize; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int lt = 0;
        int rt = list.length-1;
        int findAnswer=Integer.MAX_VALUE;
        int pos[] = new int[2];
        while (lt<rt){
            int sum = list[lt]+list[rt];
            int absSum = Math.abs(sum);
            if (absSum<=findAnswer){
                pos[0] = list[lt];
                pos[1] = list[rt];
                findAnswer = absSum;
            }
            if (sum<0){
                lt++;
            }else{
                rt--;
            }
        }
        Arrays.sort(pos);
        System.out.println(pos[0]+" "+pos[1]);
    }
}
