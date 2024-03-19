import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Integer[] list = new Integer[n-1];
        for (int i = 1; i < n; i++) {
            list[i-1] = arr[i] - arr[i-1];
        }
        Arrays.sort(list, Collections.reverseOrder());
        int sum = 0;
        for (int i = k-1; i < n-1 ; i++) {
            sum += list[i];
        }
        System.out.println(sum);
    }
}
