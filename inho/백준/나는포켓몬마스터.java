
import java.util.*;
import java.io.*;

public class 나는포켓몬마스터 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int totalMonsterCount, questionCount;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        totalMonsterCount = Integer.parseInt(st.nextToken());
        questionCount = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> hashMapForName = new HashMap<>();
        HashMap<Integer,String> hashMapForNumber = new HashMap<>();
        for (int i = 1; i <= totalMonsterCount; i++) {
            String tmpName = br.readLine();
            hashMapForName.put(tmpName,i);
            hashMapForNumber.put(i,tmpName);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questionCount; i++) {
            String tmpQuestion = br.readLine();
            //문자인지 값인지 확인해야 됨.
            try{
                int val = Integer.parseInt(tmpQuestion);
                sb.append(hashMapForNumber.get(val));
            }catch (NumberFormatException e){
                sb.append(hashMapForName.get(tmpQuestion));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
