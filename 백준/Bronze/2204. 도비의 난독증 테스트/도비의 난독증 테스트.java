import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String,String> hashMap = new HashMap<>();
        int listSize = 0;
        while ((listSize = Integer.parseInt(br.readLine()))!=0){
            String [] list = new String[listSize];
            for (int i = 0; i < listSize; i++) {
                String tmp = br.readLine();
                list[i] = tmp.toUpperCase();
                hashMap.put(list[i],tmp);
            }
            Arrays.sort(list);
            sb.append(hashMap.get(list[0])).append('\n');
        }
        System.out.println(sb);
    }
}
