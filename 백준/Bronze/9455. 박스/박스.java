import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        for (int k = 0; k < test_case; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int [][]board = new int[y][x];
            for (int i = 0; i < y; i++) {//board 생성
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int sum = 0;
            for (int j = 0; j <x; j++) { // 0을 만나면 count 올리고 1을 만나면 올린 카운트를 저장
                int count = 0;
                for (int i = (y-1); i >=0 ; i--) {
                    if(board[i][j]==0){
                        count ++;
                    }else{
                        sum += count;
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}