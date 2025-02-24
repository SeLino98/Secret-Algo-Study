import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int totalApplePie = Integer.parseInt(st.nextToken());
        int applePieCntForEat = Integer.parseInt(st.nextToken());

        int [] pieList = new int[totalApplePie];
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalApplePie; i++) {
            pieList[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < applePieCntForEat; i++) {
            total += pieList[i];
        }
        int answer = total;
        int lt = 0;
        int rt = applePieCntForEat;
        while (lt<pieList.length){
            total = total-pieList[lt++]+pieList[rt++%totalApplePie];
            answer = Math.max(total,answer);
        }
        System.out.print(answer);
    }
}
