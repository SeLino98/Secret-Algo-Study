import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listA.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < 10; i++) {
            listB.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(listA,Collections.reverseOrder());
        Collections.sort(listB,Collections.reverseOrder());
        int tmpA = 0;
        int tmpB = 0;
        for (int i = 0; i < 3; i++) {
            tmpB += listB.get(i);
            tmpA += listA.get(i);
        }
        StringBuilder sb = new StringBuilder();

        sb.append(tmpA).append(" ").append(tmpB);
        System.out.print(sb);
    }
}
