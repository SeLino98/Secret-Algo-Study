import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer arr[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,Comparator.reverseOrder());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = (i+1)+(arr[i]);
            max = Math.max(arr[i],max);
        }
        System.out.println(max+1);
    }
}
