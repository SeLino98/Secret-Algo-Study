import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        int []arr = new int[size+1];
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int range1 = Integer.parseInt(st.nextToken());
            int range2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j = range1; j <= range2; j++) {
                arr[j] = value;
            }
//            Arrays.fill(arr,range1-1,range2,value);
        }

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }


    }
}
