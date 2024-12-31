import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        // 각 단어 입력
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // 가중치 저장용 Map
        Map<Character, Integer> weightMap = new HashMap<>();

        // 각 문자에 대한 가중치 계산
        for (String word : words) {
            int power = word.length() - 1; // 자릿수 계산
            for (char ch : word.toCharArray()) {
                weightMap.put(ch, weightMap.getOrDefault(ch, 0) + (int) Math.pow(10, power));
                power--;
            }
        }

        // 가중치 기준으로 문자 정렬
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(weightMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue() - e1.getValue()); // 내림차순 정렬

        // 숫자 배정
        int value = 9;
        Map<Character, Integer> charToNumber = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            charToNumber.put(entry.getKey(), value--);
        }

        // 합산 계산
        int totalSum = 0;
        for (String word : words) {
            int wordValue = 0;
            for (char ch : word.toCharArray()) {
                wordValue = wordValue * 10 + charToNumber.get(ch);
            }
            totalSum += wordValue;
        }

        // 결과 출력
        System.out.println(totalSum);
    }
}
