import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	final int test_case = 10;
    	for (int p = 0; p < test_case; p++) {
    		br.readLine();
    		int [][]board = new int[100][100+2];
    		int Y = 0,X =0;
    		for (int i = 0; i < 100; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
					if(board[i][j]==2) {
						 Y = i;
						 X = j;
					}
				}
			}
    		while(Y!=0) {
    			if(board[Y][X-1]==1) {
    				do {
    					X--;
    				}
    				while(board[Y][X-1]!=0);
    			}else if(board[Y][X+1]==1){
    				do {
    					X++;
    				}
    				while(board[Y][X+1]!=0);
    			}
    			Y--;
    		}
    		sb.append("#").append(p+1).append(" ").append(X-1).append("\n");
    	}
    	System.out.println(sb);
    }
}