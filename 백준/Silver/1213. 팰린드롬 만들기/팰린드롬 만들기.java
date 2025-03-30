import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<Character, Integer> hash = new HashMap<>();

        // 문자 빈도수 계산
        for (char c : input.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        // 문자 정렬
        List<Character> keySet = new ArrayList<>(hash.keySet());
        Collections.sort(keySet);

        StringBuilder half = new StringBuilder();
        String middle = "";
        int oddCount = 0;

        // 팰린드롬 만들기
        for (char c : keySet) {
            int count = hash.get(c);
            if (count % 2 == 1) {
                oddCount++;
                middle = String.valueOf(c);
                if (oddCount > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
            // 절반만 추가 (나머지 절반은 뒤집어서 붙일 것)
            for (int i = 0; i < count / 2; i++) {
                half.append(c);
            }
        }

        // 팰린드롬 출력
        String result = half + middle + half.reverse();
        System.out.print(result);
    }
}
