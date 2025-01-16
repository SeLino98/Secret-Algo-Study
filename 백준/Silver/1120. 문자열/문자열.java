import java.io.IOException;
import java.io.*;
import java.util.*;
public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        char [] fList = st.nextToken().toCharArray();
        char [] sList = st.nextToken().toCharArray();

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i <= sList.length-fList.length; i++) {
            int count = 0;
            for (int j = 0; j < fList.length; j++) {
                if (fList[j]!=sList[j+i]) count++;
            }
            minValue = Math.min(count,minValue);
        }
        System.out.print(minValue);
    }
}
