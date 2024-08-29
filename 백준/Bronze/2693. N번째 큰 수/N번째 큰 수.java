import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list ;

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            sb.append(list.get(7)).append("\n");
        }
        System.out.print(sb.toString());
    }

}
