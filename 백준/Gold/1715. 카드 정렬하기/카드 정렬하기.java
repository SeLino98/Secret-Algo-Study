import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            q.add(s);

        }
        int sum = 0;
        while (!(q.size()==1)){
            int x = q.remove();
            int y = q.remove();
            int z = x+y;
            q.add(z);
            sum += x+y;
        }
        System.out.println(sum);
    }
}