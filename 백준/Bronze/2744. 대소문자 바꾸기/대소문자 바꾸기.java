import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] list = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : list
             ) {
            if (Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println(sb);
    }
}
