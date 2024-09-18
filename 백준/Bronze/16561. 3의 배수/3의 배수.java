import java.io.*;
import java.util.*;
public class Main {
    static int n ;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        combination(0, n);
        System.out.println(answer);
    }
    static void combination(int depth, int result){
        if (depth == 2){ //정답 list를 구할 필요 없으니, 그냥 카운팅
            answer++;
            return;
        }
        for (int i = 3; i < result; i+=3) {
            //i를 3씩올린다.
            //3씩 올리는데, 최종 결과에 빼고 재귀
            result -= i;
            combination(depth+1,result);
            result += i;
        }
    }
}
