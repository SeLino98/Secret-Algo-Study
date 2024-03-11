import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] arr , coin ;
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int K = sc.nextInt();
        arr = new int[K];
        coin = new int[N];
        int count =0;
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }
        int tmpCoin = 0;
        for (int i = N-1; i >=0; i--) {
            if (coin[i]<=K){
                int mux = K/coin[i];
                count+= mux;
                tmpCoin = K%coin[i];
                K = tmpCoin;
            }
        }
        System.out.println(count);
    }
}