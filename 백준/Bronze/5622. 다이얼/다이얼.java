import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Character,Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        initFunction();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] list = br.readLine().toCharArray();
        int answer = 0;
        for (char token : list) {
            answer += hashMap.get(token);
        }
        System.out.println(answer);
    }

    static void initFunction(){
        char tmp = 'A'-1;
        for (int i = 0; i < 6; i++) {
            //1,2,3
            for (int j = 0; j < 3; j++) {
                hashMap.put(tmp += 1,i+3);
            }
        }
        hashMap.put('P',8);
        hashMap.put('Q',8);
        hashMap.put('R',8);
        hashMap.put('S',8);

        hashMap.put('T',9);
        hashMap.put('U',9);
        hashMap.put('V',9);

        hashMap.put('W',10);
        hashMap.put('X',10);
        hashMap.put('Y',10);
        hashMap.put('Z',10);
    }
}
