import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String AString = br.readLine();
        int A = Integer.parseInt(AString);
        String BString = br.readLine();
        int B = Integer.parseInt(BString);
        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int firstAnswer = A+B-C;
        sb.append(firstAnswer).append('\n');
        int ABValue = Integer.parseInt(AString.concat(BString));
        int secondAnswer = ABValue - C;
        sb.append(secondAnswer);
        System.out.print(sb);
    }
}