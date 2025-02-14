import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        char [] laserList = br.readLine().toCharArray();
        if (laserList.length == 0 ) {
            System.out.print(0);
            return;
        }
        boolean flag = false;
        int answer = 0;
        int idx = 0;
        stack.push(laserList[idx]);
        while (!stack.isEmpty()&&idx<laserList.length){
            char token = stack.peek();
            if (token == ')'){
                stack.pop();
                stack.pop();
                if (!flag){//레이져를 쏘는 경우 빈 공백이 생긴다.
                    flag = true;
                    answer += stack.size();
                }else{// 쏘지 않고 파이프가 종료되는 경우
                    answer += 1;
                }
            }else{//'('인 경우
                flag = false;
            }
            if (idx== laserList.length-1) break;
            stack.push(laserList[++idx]);
        }
        System.out.print(answer);
        br.close();
    }
}