import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int listSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] list = new int[listSize];
        int [] tmpList = new int[listSize];
        boolean [] isVisited = new boolean[listSize];

        for (int i = 0; i < listSize; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        tmpList = list.clone();
        Arrays.sort(tmpList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listSize; i++) {
            for (int j = 0; j < listSize; j++) {
                if (list[i]==tmpList[j]){
                    if (isVisited[j]) continue;
                    isVisited[j] = true;
                    sb.append(j).append(" ");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}