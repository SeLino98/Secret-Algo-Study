import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        char [][] mbti ={{'I','E'},
                {'S','N'},{'T','F'},{'P','J'}};
        char [] inputData = br.readLine().toCharArray();
        for (int i = 0; i < inputData.length; i++) {
            if (mbti[i][0]==inputData[i]){
                sb.append(mbti[i][1]);
            }else{
                sb.append(mbti[i][0]);
            }
        }
        System.out.println(sb);
    }
}
