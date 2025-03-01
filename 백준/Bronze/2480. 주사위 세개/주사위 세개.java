import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int maxValue = Math.max(a,Math.max(b,c));
        int answer = 0;
        if (a==b&&a==c){
            answer = a*1000+10000;
        }else if(a!=b&&a!=c&&b!=c){
            answer = maxValue*100;
        }else{
            if(a==b){
                answer = a*100+1000;
            }else if(b == c){
                answer = b*100+1000;
            } else if(a==c){
                answer = a*100+1000;
            }
        }
        System.out.print(answer);
    }
}
