import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        int seqDay = Integer.parseInt(st.nextToken());
        int [] list = new int[numberCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberCount; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            list[i] = tmp;
        }
        int tmpValue = 0;
        for (int i = 0; i < seqDay; i++) {
            tmpValue += list[i];
        }
        int maxAnswer = tmpValue;
        for (int i = 0; i < numberCount-seqDay; i++) {
            tmpValue -= list[i];
            tmpValue += list[i+seqDay];
            maxAnswer = Math.max(tmpValue,maxAnswer);
        }
        System.out.println(maxAnswer);
    }

}
