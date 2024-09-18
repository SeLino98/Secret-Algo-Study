import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        for (int t = 1; t <= testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            list.sort(Collections.reverseOrder());
            int max = list.get(0);
            int min = list.get(size-1);
            int gap = Integer.MIN_VALUE;
            for (int i = 0; i < size-1; i++) {
                int tmpGap = Math.abs(list.get(i) - list.get(i+1));
                if (tmpGap > gap) {
                    gap = tmpGap;
                }
            }
            sb.append("Class ").append(t).append('\n');
            sb.append("Max ").append(max).append(", ").append("Min ").append(min).append(", ").append("Largest gap ").append(gap).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

}
