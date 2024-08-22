import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charList = br.readLine().toCharArray();
        int listSize = charList.length;
        int [] arrList = new int[listSize];

        int sum = 0;
        for (int i = 0; i < listSize; i++) {
            arrList[i] = charList[i] - '0';
            sum+= arrList[i];
        }

        Arrays.sort(arrList);

        if (arrList[0]!=0 || (sum%3)!=0){
            System.out.println(-1);
        }else {
            for (int i = listSize-1; i >=0; i--) {
                System.out.print(arrList[i]);
            }
        }
    }
}