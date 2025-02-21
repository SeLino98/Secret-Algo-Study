import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if ('a' <= ch && ch <= 'z') {
                sb.append((char) ((ch - 'a' + 13) % 26 + 'a'));
            } else if ('A' <= ch && ch <= 'Z') {
                sb.append((char) ((ch - 'A' + 13) % 26 + 'A'));
            } else {
                sb.append(ch);  // 알파벳이 아니면 그대로 추가
            }
        }

        System.out.print(sb);
    }
}
