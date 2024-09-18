import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char [] wordStr = br.readLine().toCharArray();
        int wordStrSize = wordStr.length;
        int [] answerListInt = new int[26];

        HashMap<Character,Integer> hashMap =  new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hashMap.put((char)('a'+i),i);
        }

        for (int i = 0; i < wordStrSize; i++) {
            char tmp = wordStr[i];
            int addIndexNum = hashMap.get(tmp);
            answerListInt[addIndexNum] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(answerListInt[i]).append(' ');
        }
        System.out.println(sb);
    }

    
}
