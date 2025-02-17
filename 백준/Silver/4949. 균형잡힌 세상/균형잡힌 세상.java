import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break; // 종료 조건
            
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            
            for (char ch : line.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isBalanced = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isBalanced = false;
                        break;
                    }
                }
            }
            
            // 모든 처리가 끝난 후, 스택이 비어 있는지 확인
            if (!stack.isEmpty()) {
                isBalanced = false;
            }
            
            sb.append(isBalanced ? "yes\n" : "no\n");
        }
        
        System.out.print(sb);
    }
}
