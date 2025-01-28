import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static String [] scoreName = {"A+","A0","B+","B0","C+","C0","D+","D0"};
    static StringTokenizer st;
    final static int testCase = 20;
    public static void main(String[] args) throws IOException{
        HashMap<String,Float> hashMap = new LinkedHashMap<>();
        float value = 5.0f;
        for (String scoreToken : scoreName) {
            hashMap.put(scoreToken,value-=0.5f);
        }
        hashMap.put("F",0.0f);
        String [] subjectList =new String[3];
        float sumExGradeScore = 0.0f;
        float sumScore = 0.0f;
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            float token = Float.parseFloat(st.nextToken());
            String tmpScoreName = st.nextToken();
            if (tmpScoreName.equals("P")) continue;
            float gradeScore = hashMap.get(tmpScoreName);
            sumExGradeScore += token*gradeScore;
            sumScore += token;
        }
        System.out.print(Math.round(sumExGradeScore/sumScore*1000000)/1000000.0);
    }
}
