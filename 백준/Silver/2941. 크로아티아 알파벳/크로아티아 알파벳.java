import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 크로아티아 알파벳 목록
        String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 크로아티아 알파벳을 하나의 문자로 치환
        for (String alphabet : croatianAlphabets) {
            input = input.replace(alphabet, "x");
        }

        // 치환된 문자열의 길이가 크로아티아 알파벳의 개수
        System.out.println(input.length());
    }
}
