import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int chessSize = 8;
    public static void main(String[] args) throws IOException{
        int answer = 0;
        for (int i = 0; i < chessSize; i++) {
            char [] list = br.readLine().toCharArray();
            for (int j = 0; j < chessSize; j++) {
                if (i%2==0){
                    if (j%2==0&&list[j]=='F') answer++;
                }else{
                    if (j%2!=0&&list[j]=='F') answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
