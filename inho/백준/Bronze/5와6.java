import java.util.*;
import java.io.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        char [] num1List = st.nextToken().toCharArray();
        char [] num2List = st.nextToken().toCharArray();
        int range = Math.min(num2List.length, num1List.length);

        for (int i = 0; i < num1List.length; i++) {
            if (num1List[i]=='6') num1List[i] = '5';
        }
        for (int i = 0; i < num2List.length; i++) {
            if (num2List[i]=='6') num2List[i] = '5';
        }
        int minValue = 0;
        int ten = 1;
        for (int i = 0; i < range; i++) {
            minValue += (num2List[num2List.length-1-i]-'0')*ten + (num1List[num1List.length-1-i]-'0')*ten;
            ten *= 10;
        }
        for (int i = 0; i < num1List.length; i++) {
            if (num1List[i]=='5') num1List[i] = '6';
        }
        for (int i = 0; i < num2List.length; i++) {
            if (num2List[i]=='5') num2List[i] = '6';
        }
        int maxValue = 0;
        ten = 1;
        for (int i = 0; i < range; i++) {
            maxValue += (num2List[num2List.length-1-i]-'0')*ten + (num1List[num1List.length-1-i]-'0')*ten;
            ten *= 10;
        }
        System.out.println(minValue+" "+maxValue);
    }
}
