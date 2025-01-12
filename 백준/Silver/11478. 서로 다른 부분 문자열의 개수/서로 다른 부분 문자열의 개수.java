import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Set<String> substrings = new HashSet<>();

        for (int length = 1; length <= input.length; length++) {
            for (int start = 0; start <= input.length - length; start++) {
                substrings.add(new String(input, start, length));
            }
        }

        System.out.println(substrings.size());
    }
}