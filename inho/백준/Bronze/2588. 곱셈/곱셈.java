import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        String value2 = br.readLine();
        char[] valueNum = value2.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i =  valueNum.length-1; i >=0 ; i--) {
            int multiNum = valueNum[i]-'0';
            int sum = multiNum*value;
            sb.append(sum).append("\n");
        }
        int fullVal = Integer.parseInt(value2);
        int sum = value*fullVal;
        sb.append(sum);
        System.out.print(sb);
        br.close();
    }
}
