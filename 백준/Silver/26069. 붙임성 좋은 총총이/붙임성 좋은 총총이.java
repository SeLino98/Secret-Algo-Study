import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        HashSet<String> rat = new HashSet<>();
        rat.add("ChongChong");
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            String aRat = st.nextToken();
            String bRat = st.nextToken();
            if (rat.contains(aRat)&&rat.contains(bRat)) continue;
            if (rat.contains(bRat)){
                rat.add(aRat);
            } else if (rat.contains(aRat)) {
                rat.add(bRat);
            }
        }
        System.out.print(rat.size());
    }
}
