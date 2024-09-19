import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int personNumber = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean [] isChecked = new boolean[101];
        int answer = 0;
        for (int i = 0; i < personNumber; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (isChecked[tmp]){
                answer++;
            }else{
                isChecked[tmp] = true;
            }
        }
        System.out.println(answer);
    }

}
