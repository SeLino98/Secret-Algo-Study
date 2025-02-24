import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static boolean[] isVisited;
    static int [] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int arrSize = Integer.parseInt(br.readLine());
            list = new int[arrSize+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < list.length; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            isVisited = new boolean[list.length];
            int answer = 0;
            for (int i = 1; i < list.length; i++) {
                if (isVisited[i]) continue;
                backTrack(i);
                answer++;
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
    static void backTrack(int col){
        if (isVisited[col]) return;
        isVisited[col] = true;
        backTrack(list[col]);
    }
}
