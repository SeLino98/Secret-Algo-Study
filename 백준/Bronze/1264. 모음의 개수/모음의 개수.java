import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strint = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!strint.equals("#")){
            int count = 0;
            char [] list = strint.toCharArray();
            for (int i = 0; i < list.length; i++) {
                if (list[i]=='a'||list[i]=='e'||list[i]=='i'||list[i]=='o'||list[i]=='u'
                ||list[i]=='A'||list[i]=='E'||list[i]=='I'||list[i]=='O'||list[i]=='U') count++;
            }
            sb.append(count).append("\n");
            strint = br.readLine();
        }
        System.out.print(sb);
    }
}
