import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 1; i < 9; i++) {
            int score = Integer.parseInt(br.readLine());
            hashMap.put(score,i);
        }
        List<Integer> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList,Collections.reverseOrder());
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += arrayList.get(i);
        }
        sb.append(total).append('\n');
        int[] list = new int[5];
        for (int i = 0; i < 5; i++) {
            list[i] = hashMap.get(arrayList.get(i));

        }
        Arrays.sort(list);
        for (int i = 0; i < 5; i++) {
            sb.append(list[i]).append(" ");
        }
        System.out.print(sb);
    }
}
