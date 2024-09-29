import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][]map = new char[5][15];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(map[i], (char) -1);
        }
        for (int i = 0; i < 5; i++) {
            char [] tmpList = br.readLine().toCharArray();
            for (int j = 0; j < tmpList.length; j++) {
                map[i][j] = tmpList[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[j][i]==(char)-1) continue;
                char tmp = map[j][i];
                sb.append(tmp);
            }
        }
        System.out.print(sb);
    }
}
