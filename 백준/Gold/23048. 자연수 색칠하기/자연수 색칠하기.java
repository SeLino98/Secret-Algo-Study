import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int cheSize;
    static boolean[] isNotPrime;
    static int[] paintCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        cheSize = Integer.parseInt(br.readLine());
        isNotPrime = new boolean[cheSize+1];
        paintCount = new int[cheSize+1];
        isNotPrime[1] = true;
        paintCount[1] = 1;
        int count = 2;
        if (cheSize== 1){
            sb.append(1).append("\n").append(1);
        }else{
            for (int i = 2; i <= cheSize; i++) {
                if (isNotPrime[i]) continue;
                for (int j = i; j <=cheSize ; j+=i) {
                    isNotPrime[j] =true;//2 4 6 다 트루로 체킹
                    paintCount[j]= count;
                }
                count++;
            }
            sb.append(count-1).append("\n");
            for (int i = 1; i <= cheSize; i++) {
                sb.append(paintCount[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
