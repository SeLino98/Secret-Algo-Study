import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalMoney = Integer.parseInt(br.readLine());
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            totalMoney -= money*count;
        }
        if (totalMoney!=0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }

    }
}