import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        char [] hashTokens = "CAMBRIDGE".toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < hashTokens.length; i++) {
            set.add(hashTokens[i]);
        }
        char [] inputList = br.readLine().toCharArray();
        for (int i = 0; i < inputList.length; i++) {
            if (!set.contains(inputList[i])){
                sb.append(inputList[i]);
            }
        }
        System.out.print(sb);
    }
}