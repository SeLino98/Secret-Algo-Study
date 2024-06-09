import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        boolean [][]map = new boolean[101][101];
        StringTokenizer st;
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x+10; i++) {
                for (int j = y; j < y+10; j++) {
                    map[i][j] = true;
                }
            }
        }
        int answerCount = 0;
        for (int i = 0; i <101; i++) {
            for (int j = 0; j < 101; j++) {
                if(map[i][j]){
                    answerCount++;
                }
            }
        }
        System.out.println(answerCount);
    }
}
