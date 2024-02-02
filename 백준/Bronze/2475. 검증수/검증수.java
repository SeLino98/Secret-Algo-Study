import java.util.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
		
			int n = sc.nextInt();
			int tmp = n*n;
			sum += tmp;
			
		}
		int answer = sum%10;
		System.out.println(answer);
	}
}