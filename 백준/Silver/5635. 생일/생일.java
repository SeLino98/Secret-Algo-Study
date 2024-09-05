import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peopleNum = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        HashMap<Integer,String> hashMap = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < peopleNum; p++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            int total = (year*10000)+(month*100)+day;
            hashMap.put(total,name);
        }
        ArrayList<Integer> nameList = new ArrayList<>(hashMap.keySet());
        Collections.sort(nameList,Collections.reverseOrder());
        sb.append(hashMap.get(nameList.get(0))).append('\n').append(hashMap.get(nameList.get(peopleNum-1)));
        System.out.print(sb);
    }
}
