import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char [] answer = new char[0];
        for (int t = 0; t < testCase; t++) {
            char [] tmpList = br.readLine().toCharArray();
            if (t == 0){
                answer = tmpList.clone();
            }
            for (int i = 0; i < tmpList.length; i++) {
                if (tmpList[i] != answer[i]){
                    answer[i] = '?';
                }
            }
        }
        for (char token : answer) {
            sb.append(token);
        }
        System.out.println(sb);
    }
}