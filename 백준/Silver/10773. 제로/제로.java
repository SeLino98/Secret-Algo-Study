import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int t = 0; t < testCase; t++) {
            int token = Integer.parseInt(br.readLine());
            if (token==0){
                stack.pop();
            }else{
                stack.push(token);
            }
        }
        int answer = 0;
        while (!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.print(answer);
    }
}
