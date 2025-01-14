import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int breakedLine = Integer.parseInt(st.nextToken());
        int numBrand = Integer.parseInt(st.nextToken());
        int minPackage = Integer.MAX_VALUE;
        int minOneEach = Integer.MAX_VALUE;
        for (int i = 0; i < numBrand; i++) { //패키지 최소 낱개 최소 구하기
            st = new StringTokenizer(br.readLine());
            int tmpNumPackage = Integer.parseInt(st.nextToken());
            int tmpNumOneEach = Integer.parseInt(st.nextToken());
            minPackage = Math.min(tmpNumPackage,minPackage);
            minOneEach = Math.min(tmpNumOneEach,minOneEach);
        }
        //패키지로만
        int count = 1;
        while (6*count<=breakedLine){
            count++;
        }
        int answer = minPackage*count;
        //섞어서
        int tmp1 = (breakedLine/6)*minPackage;
        int tmp2 = breakedLine%6;
        int tmp3 = tmp2*minOneEach;
        answer = Math.min(answer,tmp1+tmp3);
        //낱개로만
        answer = Math.min(answer, breakedLine*minOneEach);
        //정답 출력
        System.out.print(answer);
    }
}
