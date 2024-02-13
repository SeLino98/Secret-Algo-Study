import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] isVisited;
    static int[] list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        list = new int[N];
        isVisited = new boolean[N];
        Permutation(0,0,list);
        System.out.println(sb);
    }
    static void Permutation(int start, int depth, int[] answer){
        if (depth==N){
            for (int i = 0; i < answer.length; i++) {
//                System.out.print(answer[i]+" ");
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]){
                isVisited[i] = true;
                answer[start]= i+1;
                Permutation(start+1,depth+1,answer);
                isVisited[i] = false;
            }
        }
    }
}
