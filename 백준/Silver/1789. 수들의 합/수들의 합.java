import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long count = 0;
        if (S == 1){
            System.out.println(1);
            return;
        }
        for (long i = 1; i <= S; i++) {
            sum += i;
            count++;
            if (S<sum) break;
        }
        System.out.println(count-1);
    }
}
