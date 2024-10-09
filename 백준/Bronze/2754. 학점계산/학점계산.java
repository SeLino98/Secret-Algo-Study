import java.io.*;
import java.util.*;
public class Main {
    static String[] list = {
            "A+","A0","A-", "B+","B0","B-",
            "C+","C0","C-", "D+","D0","D-",
            "F"
    };
    static float[] listScore = {
            4.3f,4.0f,3.7f, 3.3f,3.0f,2.7f,
            2.3f,2.0f,1.7f,1.3f,1.0f,0.7f,
            0.0f
    };
    public static void main(String[] args) throws IOException {
        HashMap<String,Float> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < 13; i++) {
            hashMap.put(list[i],listScore[i]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c_score = br.readLine();
        System.out.print(hashMap.get(c_score));
    }
}
