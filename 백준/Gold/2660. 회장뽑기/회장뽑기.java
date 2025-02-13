import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int personCount;
    static final int maxValue  = 100;
    public static void main(String[] args) throws IOException {

        personCount = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        int [][] friendMap = new int[personCount][personCount];
        for (int i = 0; i < personCount; i++) {
            Arrays.fill(friendMap[i],maxValue);
        }
        while (true){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken())-1;
            int p2 = Integer.parseInt(st.nextToken())-1;
            if (p1<0||p2<0){
                break;
            }
            friendMap[p1][p2] = 1;
            friendMap[p2][p1] = 1;
        }

        for (int k = 0; k < personCount; k++) {
            for (int i = 0; i < personCount; i++) {
                for (int j = 0; j < personCount; j++) {
                    if (maxValue==friendMap[i][k]||maxValue==friendMap[k][j]) continue;
                    if (i==j) continue;
                    friendMap[i][j] = Math.min(friendMap[i][j],friendMap[i][k]+friendMap[k][j]);
                }
            }
        }
        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < personCount; i++) {
            int tmpMaxScore = Integer.MIN_VALUE;
            for (int j = 0; j < personCount; j++) {
                if (i==j) continue;
                tmpMaxScore = Math.max(tmpMaxScore,friendMap[i][j]);
            }
            minScore = Math.min(minScore,tmpMaxScore);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            int tmpMaxScore = 0 ;
            for (int j = 0; j < personCount; j++) {
                if (i==j) continue;
                tmpMaxScore = Math.max(tmpMaxScore,friendMap[i][j]);
            }
            if (minScore==tmpMaxScore) list.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(list.size()).append('\n');
        for (int token:list) {
            sb.append(token).append(" ");
        }
        System.out.print(sb);
    }
}
