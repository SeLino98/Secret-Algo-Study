import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static boolean[] isVisited;
    static int[] element;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        element = new int[n]; // 원소들을 담는 배열.
        answer = new int[m]; // 선택받은 원소들이 담길 배열
        isVisited = new boolean[n]; //저장될 원소들의 사용 유무
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            element[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(element);
        Permutation(0);
        System.out.println(sb);
    }
    static void Permutation(int start){
        if (start==answer.length){
            for (int i = 0; i < start; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!isVisited[i]){
                isVisited[i] = true;
                answer[start] = element[i];
                Permutation(start+1);
                isVisited[i] = false;
            }
        }
    }
}
