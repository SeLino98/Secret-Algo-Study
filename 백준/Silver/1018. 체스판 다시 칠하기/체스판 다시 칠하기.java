import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        //처음 수가 W인지 B인지 나눠서 체크하기
        //맵 값 받기
        char [][]map = new char[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int answer = Integer.MAX_VALUE;
        //3중 포문으로 체크하기
        for (int i = 0; i < rowSize-7; i++) {
            for (int j = 0; j < colSize-7; j++) {
                int totalCount = 0;
                for (int r = 0; r < 8; r++) {
                    char [] tmpList = new char[8];
                    for (int c = 0; c < 8; c++) {
                        tmpList[c] = map[i+r][j+c];
                    }
                    if (r%2==0){
                        totalCount += firstWhiteTile(tmpList,true);
                    }else{
                        totalCount += firstWhiteTile(tmpList,false);
                    }
                }
                if (totalCount>32){//전체 갯수가 적을 때 값 그대로
                    totalCount = 64-totalCount;
                }
                answer = Math.min(totalCount,answer);
            }
        }
        System.out.print(answer);
    }
    static int firstWhiteTile(char [] list,boolean isWhite ){
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (i%2==0){//짝수 일 때
                if (isWhite){
                    if (list[i]!='W') count++;
                }else{
                    if (list[i]!='B') count++;
                }
            }else{//홀 수 일 때
                if (isWhite){
                    if (list[i]!='B')count++;
                }else{
                    if (list[i]!='W') count++;
                }
            }
        }
        return count;
    }
}