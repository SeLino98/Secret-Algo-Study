import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static long[] costList ;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        //999983
        //123456789
        //10 123257223
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        costList = new long[N+1];
        isPrime = new boolean[N+1];
        isPrime[1]= true;
        costList[1] = 1;
        for (int i = 0; i < costList.length; i++) {
            costList[i]= i;
        }
        //체로 저장
        for (int i = 2; i <=N/2; i++) {
            for (int j = i; j <= N-i; j+=i) {
                costList[j+i] /= costList[i];
            }
        }
        long answer = 1;
        for(int i = 1; i < costList.length ; i++) {
            answer *= costList[i];
            answer%=(long)987654321;
        }
        System.out.println(answer);
        //저장배열에서 나눠보기
        //1 2 3 4 5 6 7 8 9 10
        //1 2   2   2   2   2
        //1 2 3 2   3     3
        //1 2 3 2 5 6 7 8 9 10
        //나눈 값저장
        //방문 체크,
    }
}