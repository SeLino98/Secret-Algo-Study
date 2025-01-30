import java.io.*;
import java.util.*;
public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,H;
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)  throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int [] btmTunnelList = new int[H];
        int [] highTunnelList = new int[H];
        for (int i = 0; i < N; i++) {
            int tmpPos = Integer.parseInt(br.readLine());
            if (i%2==0){//짝수 석순
                btmTunnelList[tmpPos-1] ++;
            }else{//홀수 종유석
                highTunnelList[H-tmpPos] ++;
            }
        }
        int [] answerList = new int[H];
        for (int i = btmTunnelList.length-1;  i > 0 ; i--) {
            btmTunnelList[i-1] += btmTunnelList[i];
        }
        for (int i = 0; i < H-1; i++) {
            highTunnelList[i+1] += highTunnelList[i];
        }
        for (int i = 0; i < answerList.length; i++) {
            answerList[i] = btmTunnelList[i]+highTunnelList[i];
        }
        Arrays.sort(answerList);
        int firstAnswer = answerList[0];
        int secondAnswer = 0;
        for (int i = 0; i < answerList.length; i++) {
            if (answerList[i]!=firstAnswer){
                break;
            }else{
                secondAnswer++;
            }
        }
        sb.append(firstAnswer).append(" ").append(secondAnswer);
        System.out.print(sb);
    }
}


