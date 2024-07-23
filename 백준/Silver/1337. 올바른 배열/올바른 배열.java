import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hashSet = new HashSet<>();
        int arrSize = Integer.parseInt(br.readLine());
        for (int a = 0; a < arrSize; a++) {
            int inputValue = Integer.parseInt(br.readLine());
            hashSet.add(inputValue);
        }
        int result = Integer.MAX_VALUE;
        for (int token : hashSet) {
            int cnt = 0; //충원해야할 배열의 갯수
            for (int i = 1; i < 5; i++) {
                if (!hashSet.contains(token+i))cnt++;
            }
            result = Math.min(result,cnt); //최소 갯수 갱신
        }
        System.out.println(result);
    }
}