import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        char [] aList = br.readLine().toCharArray();
        char oper = br.readLine().charAt(0);
        char [] bList = br.readLine().toCharArray();

        if (oper == '*'){
            int aSize = aList.length-1;
            int bSize = bList.length-1;
            sb.append(1);
            for (int i = 0; i < aSize+bSize; i++) {
                sb.append(0);
            }
        }else{
            sb.append(addStrings(aList, bList));
        }
        System.out.print(sb);
    }
    static String addStrings(char[] smallList, char[] bigList) {
        if (smallList.length > bigList.length) {
            return addStrings(bigList, smallList); // 작은 숫자가 앞에 오도록 정렬
        }

        StringBuilder sb = new StringBuilder();
        int diff = bigList.length - smallList.length;

        for (int i = 0; i < bigList.length; i++) {
            if (i == diff) {
                sb.append((char) (bigList[i] + smallList[0] - '0'));
            } else {
                sb.append(bigList[i]);
            }
        }
        return sb.toString();
    }

}
