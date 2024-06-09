import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	boolean[]isCheck = new boolean[N+1];
    	Arrays.fill(isCheck, true);
    	int count = 0;
    	int saveNum = 0;
    	for (int i = 2; i <= N; i++) {
        		int nextNum=i;
        		int per = 1;
        		while(nextNum<=N){
        			if(isCheck[nextNum]) {
        				isCheck[nextNum] = false;
        				count++;
        			}
        			if(count==K) {
        				saveNum =nextNum; 
        				break;
        			}
        			nextNum = i*per;
        			per++;
        		}	
        		if(count==K) {
    				break;
    			}
    	}
    	System.out.println(saveNum);
    }
}