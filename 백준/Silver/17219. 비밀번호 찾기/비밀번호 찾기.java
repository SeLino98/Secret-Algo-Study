import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String findStr, answer = "";
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String [] str = br.readLine().split(" ");
            hashMap.put(str[0],str[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            findStr = br.readLine();
            answer = hashMap.get(findStr);
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
