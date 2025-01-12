import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static Set<String> set = new HashSet<>();
    static char [] list ;
    public static void main(String[] args) throws IOException {
        list = br.readLine().toCharArray();
        for (int i = 1; i <= list.length; i++) {//1. Set으로 저장한다.
            inputSetBox(i);
        }
        System.out.print(set.size());//2. set 사이즈를 출력한다.
    }
    static void inputSetBox(int range){
        for (int i = 0; i <= list.length-range; i++) {
            sb = new StringBuilder();
            for (int j = i; j < i+range; j++) {
                sb.append(list[j]);
            }
            set.add(sb.toString());
        }
    }
}
