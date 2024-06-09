import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	//복권문제 
	//조합의 경우를 구하자.
	static int[] lotto;
	static int[] selectLotto = new int[6];
	static final int selNum = 6;
	static ArrayList<String> answer ;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			lotto = new int[N];
			answer = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(lotto);
			comBiLotto(0,0,"");	
			for (String string : answer) {
				sb.append(string.substring(1)).append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	static void comBiLotto(int idx, int count, String row ) {
		if(count ==selNum) {
			answer.add(row); 
			return ;
		}
		for (int i = idx; i < lotto.length; i++) {
			selectLotto[count] = lotto[i];
			comBiLotto(i+1,count+1,row+" "+selectLotto[count]);
		}
	}
}
