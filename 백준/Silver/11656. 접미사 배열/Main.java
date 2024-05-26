import java.util.*;
import java.io.*;
public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] tmpList = br.readLine().toCharArray();
        String[] answerList = new String[tmpList.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmpList.length; i++) {
            answerList[i] = "";
            for (int j = i; j < tmpList.length; j++) {
                answerList[i] += tmpList[j];
            }
        }
        Arrays.sort(answerList);
        for(String token : answerList){
            sb.append(token).append("\n");
        }
//        System.out.println(Arrays.toString(answerList));
        System.out.println(sb);
    }
}