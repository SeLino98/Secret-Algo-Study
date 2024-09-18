import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }
        Collections.sort(arr,Collections.reverseOrder());
        for (int token:
             arr) {
            sb.append(token).append('\n');
        }
        System.out.print(sb);
    }
}
