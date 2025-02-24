import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int [] list = new int[2];
        list[0] = Integer.parseInt(st.nextToken());
        list[1] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        int gcd = getGCD(list[0],list[1]);
        int lcm = (list[0]*list[1])/gcd;
        System.out.print(gcd + "\n"+ lcm);
    }
    static int getGCD(int n1, int n2){
        if (n1%n2==0){
            return n2;
        }
        return getGCD(n2,n1%n2);
    }
}
