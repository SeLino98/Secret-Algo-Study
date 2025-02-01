import java.util.*;
import java.io.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int payListSize = Integer.parseInt(st.nextToken());
        int junWorkSize = Integer.parseInt(st.nextToken());
        int [] list = new int[payListSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        long maxPay = 0;
        for (int i = 0; i < junWorkSize; i++) {
            maxPay += list[i];
        }
        
        long tmpPay = maxPay;
        for (int i = junWorkSize; i < payListSize; i++) {
            tmpPay -= list[i - junWorkSize];
            tmpPay += list[i];
            maxPay = Math.max(tmpPay,maxPay);
        }
        System.out.print(maxPay);
    }
}
