import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m ;
    static List<Integer> answer ;
    static ArrayList<Integer> list;
    static StringBuilder sb  = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();    // 순열의 전체 리스트
        answer = new LinkedList<>(); // 정답을 담을 리스트
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list); // 사전순으로 정렬
        combination(0, 0); // 현재 선택된 원소의 개수도 0으로 설정
        System.out.println(sb);
    }

    static void combination(int start, int depth) {
        if (depth == m) {
            for (Integer token : answer) {
                sb.append(token).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            answer.add(list.get(i));
            combination(i + 1, depth + 1); // 현재 인덱스보다 1 큰 인덱스부터 시작하고, 깊이 1 증가
            answer.remove(answer.size() - 1);
        }
    }
}