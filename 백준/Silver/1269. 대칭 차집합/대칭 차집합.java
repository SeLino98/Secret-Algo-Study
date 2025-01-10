import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        //SET으로 넣고 값이 있다면 그값 갯수 카운팅
        Set<Integer> set = new HashSet<>();
        //a 값 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            set.add(tmp);
        }
        //b 값 입력
        int dupCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (set.contains(tmp)) dupCount++;
        }
        //a집합 전체 갯수 - 카운팅 된 값 = A-B
        int aMinusB = aSize - dupCount;
        //b집합 전체 갯수 - 카운팅 된 값 = B-A
        int bMinusA = bSize - dupCount;
        //두 집합의 합 = answer
        System.out.print(aMinusB+bMinusA);
    }
}
