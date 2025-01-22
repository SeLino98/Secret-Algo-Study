import java.io.*;
import java.util.*;
public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int personCount = Integer.parseInt(br.readLine());
        float [] scoreList = new float[personCount];
        for (int i = 0; i < personCount; i++) {
            scoreList[i] = Float.parseFloat(br.readLine());
        }
        Arrays.sort(scoreList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f",scoreList[i])).append('\n');
        }
        System.out.print(sb);
    }
}
