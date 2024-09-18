import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int [] list = {0,0,w,h};
        //(0,0) (w,h) 비교해서 작은 것 출력
        //4방향 검사
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            int tmp = 0;
            if (i%2==0){
                tmp = Math.abs(x-list[i]);
            }else{
                tmp = Math.abs(y-list[i]);
            }
            min = Math.min(min,tmp);
        }
        System.out.print(min);
    }
}