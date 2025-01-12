import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hash = new HashMap<>();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String []tmp = br.readLine().split("\\.");
            hash.put(tmp[1],hash.getOrDefault(tmp[1],0)+1);
        }
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(hash.entrySet());
        list.sort((s1, s2) -> s1.getKey().compareTo(s2.getKey()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Integer> token:list
             ) {
            sb.append(token.getKey()).append(" ").append(token.getValue()).append('\n');
        }
        System.out.println(sb);
    }
}
