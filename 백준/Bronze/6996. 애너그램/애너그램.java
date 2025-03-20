import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (isAnagram(A, B)) {
                sb.append(A).append(" & ").append(B).append(" are anagrams.");
            } else {
                sb.append(A).append(" & ").append(B).append(" are NOT anagrams.");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 문자열 정렬을 이용한 애너그램 판별 함수
    private static boolean isAnagram(String A, String B) {
        if (A.length() != B.length()) return false;

        char[] listA = A.toCharArray();
        char[] listB = B.toCharArray();

        Arrays.sort(listA);
        Arrays.sort(listB);

        return Arrays.equals(listA, listB);
    }
}
