import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 10;
        int total = 0;
        int answer = 0;
        boolean isChecked = false;
        for (int t = 0; t < testCase; t++) {
            int tmp = Integer.parseInt(br.readLine());
            int tmpSum = total+tmp;
            if ((tmpSum)>=100){
                //비교한다.
                //total vs total+tmp
                int a = Math.abs(100 - total);
                int b = Math.abs(100 - tmpSum);
                if (a<b){
                    answer = total;
                }else{//같다면 큰 값인 b를 준다.
                    answer = tmpSum;
                }
                isChecked = true;
                break;
            }else {
                total += tmp;
            }
        }
        if (isChecked){
            System.out.println(answer);
        }else{
            System.out.println(total);
        }
        
    }
}