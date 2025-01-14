import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N+1];
        if (N==3){
            System.out.println(1);
        }else if(N==4){
            System.out.println(-1);
        }else if (N==5){
            System.out.println(1);
        }else{
            list[1] = -1;
            list[2] = -1;
            list[3] = 1;
            list[4] = -1;
            list[5] = 1;
            for (int i = 6; i < N+1; i++) {
                if (list[i-5]!=-1){
                    list[i] = list[i-5]+1;
                }else if (list[i-3]!=-1){
                    list[i] = list[i-3]+1;
                }else{
                    list[i] = -1;
                }
            }
            System.out.println(list[N]);
        }
    }
}
