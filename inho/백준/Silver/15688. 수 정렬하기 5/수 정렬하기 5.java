import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            arr.add(n);
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int token: arr
             ) {
            sb.append(token).append('\n');
        }
        System.out.println(sb);
    }
}