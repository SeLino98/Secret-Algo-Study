import java.util.*;
import java.io.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String [] list = br.readLine().split("-");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            char token = list[i].charAt(0);
            sb.append(token);
        }
        System.out.print(sb);
    }
}
