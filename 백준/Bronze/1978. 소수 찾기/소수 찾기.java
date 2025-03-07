import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n>1&&isSo(n)){
                answer++;
            }
        }
        System.out.print(answer);
    }

    static boolean isSo(int n){
        for (int i = 2; i < n; i++) {
            if (n%i==0) return false;
        }
        return true;
    }
}