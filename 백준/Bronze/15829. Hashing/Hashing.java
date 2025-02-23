import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int MOD_VALUE = 1234567891;
    final static int MOD_R = 31;
    public static void main(String[] args)throws IOException {
        int wordSize = Integer.parseInt(br.readLine());
        char [] wordList = br.readLine().toCharArray();
        long answer = 0;
        for (int i = 0; i < wordSize; i++) {
            answer +=((wordList[i]-'a'+1)*Math.pow(MOD_R,i))%MOD_VALUE;
        }
        System.out.print(answer);
    }
}
