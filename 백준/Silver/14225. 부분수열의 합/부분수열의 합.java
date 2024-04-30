import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited ;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[size];
        int visitedSize = 0;
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            visitedSize+= list[i];
        }
        isVisited = new boolean[visitedSize+2];
        combi(size,0,0);
        int answer = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]){
                answer=i;
                break;
            }
        }
        System.out.print(answer);
    }
    static void combi(int size,int depth,int sum){
        if (depth==size){
            isVisited[sum] = true;
            return;
        }
        combi(size,depth+1,sum);
        combi(size,depth+1,sum+list[depth]);
    }
}
