import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int []list = new int[3];
        for(int i =0;i<3;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        for(int i = 0; i<3; i++){
            sb.append(list[i]).append(" ");
        }
        System.out.print(sb);
    }
}