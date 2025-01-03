import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityTotal = Integer.parseInt(br.readLine());
        int [] cityDistanceList = new int[cityTotal];
        int [] cityPayList = new int[cityTotal];
        StringTokenizer st;
        //입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityDistanceList.length-1; i++) {
            cityDistanceList[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityPayList.length; i++) {
            cityPayList[i] = Integer.parseInt(st.nextToken());
        }
        //계산
        int nextPos = 0;
        int answer = 0;
        for (int p = 0; p < cityPayList.length; p++) {
            boolean isFlag = false;
            while (nextPos<cityTotal&&cityPayList[p]<=cityPayList[nextPos]){
                isFlag = true;
                answer += cityPayList[p]*cityDistanceList[nextPos];
                nextPos++;
            }
            if (isFlag) p = nextPos-1;
        }
        System.out.print(answer);
    }
}