import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        char [] list = br.readLine().toCharArray();
        Arrays.sort(list);
        for (int i = list.length-1; i >= 0; i--) {
            sb.append(list[i]);
        }
        System.out.println(sb);
    }
}