import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordSize = Integer.parseInt(br.readLine());
        String[] list = new String[wordSize];
        Map<Character, Long> weightMap = new HashMap<>();

        // 각 문자에 대한 가중치 계산
        for (int i = 0; i < wordSize; i++) {
            String tmp = br.readLine();
            list[i] = tmp;
            int power = tmp.length() - 1;
            for (char token : tmp.toCharArray()) {
                weightMap.put(token, weightMap.getOrDefault(token, 0L) + (long) Math.pow(10, power));
                power--;
            }
        }

        // 가중치 기준으로 문자 정렬
        List<Map.Entry<Character, Long>> sortedEntries = new ArrayList<>(weightMap.entrySet());
        sortedEntries.sort((o1, o2) -> Long.compare(o2.getValue(), o1.getValue()));

        // 숫자 배정
        int value = 9;
        Map<Character, Integer> charToNumber = new LinkedHashMap<>();
        for (Map.Entry<Character, Long> tokenMap : sortedEntries) {
            charToNumber.put(tokenMap.getKey(), value--);
        }

        // 합산 계산
        long answer = 0;
        for (int i = 0; i < wordSize; i++) {
            long tmpValue = 0;
            for (char s : list[i].toCharArray()) {
                tmpValue = tmpValue * 10 + charToNumber.get(s);
            }
            answer += tmpValue;
        }
        System.out.println(answer);
    }
}
