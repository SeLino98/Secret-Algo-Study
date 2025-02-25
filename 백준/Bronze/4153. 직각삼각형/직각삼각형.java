import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            int [] list = new int[3];
            list[0] = Integer.parseInt(st.nextToken());
            list[1] = Integer.parseInt(st.nextToken());
            list[2] = Integer.parseInt(st.nextToken());
            if (list[0] == 0) break;
            boolean isAnswer = false;
            list[0] *= list[0];
            list[1] *= list[1];
            list[2] *= list[2];
            if (list[0]+list[1]==list[2]||list[1]+list[2]==list[0]||list[2]+list[0]==list[1])isAnswer = true;
            if (isAnswer){
                sb.append("right");
            }else{
                sb.append("wrong");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}