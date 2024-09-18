import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int msgLength = Integer.parseInt(st.nextToken());
        int maxValue = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < msgLength; i++) {
            int tmp  = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(tmp)){
                int getCount = hashMap.get(tmp);
                hashMap.put(tmp,getCount+1);
            }else{
                hashMap.put(tmp,1);
            }
        }

        ArrayList<Map.Entry<Integer,Integer>> answerList = new ArrayList<>(hashMap.entrySet());
        answerList.sort((o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer,Integer> entry: answerList) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        System.out.print(sb);
    }
}
