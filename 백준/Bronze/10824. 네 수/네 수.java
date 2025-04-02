import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String abSum = a.concat(b);
        String c = st.nextToken();
        String d = st.nextToken();
        String cdSum = c.concat(d);

        long abTotal = Long.parseLong(abSum);
        long cdTotal = Long.parseLong(cdSum);

        System.out.println(abTotal+cdTotal);

    }
}
