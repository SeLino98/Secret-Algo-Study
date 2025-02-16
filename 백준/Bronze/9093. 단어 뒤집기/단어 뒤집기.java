import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            String [] wordList = br.readLine().split(" ");
            for (int i = 0; i < wordList.length; i++) {
                char [] reverseWordList = new char[wordList[i].length()];
                char [] tmpWordList = wordList[i].toCharArray();
                for (int j = tmpWordList.length-1; j >= 0; j--) {
                    reverseWordList[tmpWordList.length-1-j] = tmpWordList[j];
                }
                for (char token: reverseWordList) {
                    sb.append(token);
                }
                sb.append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
