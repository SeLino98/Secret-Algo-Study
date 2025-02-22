import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int testCase = 5;
    static char []fbiWord = {'F','B','I'};
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        boolean isCanAnswer = false;
        for (int t = 0; t < testCase; t++) {
            char [] tmpList = br.readLine().toCharArray();
            int count = 0;
            for (int i = 0; i < tmpList.length-2; i++) {
                count = 0;
                for (int j = 0; j < 3; j++) {
                    if (fbiWord[j] == tmpList[i + j]) {
                        count++;
                    }
                }
                if (count==3) {
                    sb.append(t+1).append(' ');
                    isCanAnswer = true;
                    break;
                }
            }
        }
        if (isCanAnswer){
            System.out.print(sb);
        }else{
            System.out.print("HE GOT AWAY!");
        }
    }
}