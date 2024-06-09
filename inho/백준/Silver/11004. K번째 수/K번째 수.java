import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = Integer.parseInt(st.nextToken());
        int findNum = Integer.parseInt(st.nextToken())-1;

        int [] list = new int[arrSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        System.out.print(list[findNum]);
    }

}
