import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) throws IOException {
 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = n; i > 0; i--) {
			System.out.println(i);
		}
	}
}