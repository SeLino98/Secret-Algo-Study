import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase  =Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            switch (val){
                case 1 :
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case 2 :
                    if (!stack.isEmpty()){
                        if (stack.peek()>=0||stack.peek()<0){
                            sb.append(stack.pop());
                        }
                    }else{
                        sb.append(-1);
                    }
                    sb.append('\n');
                    break;
                case 3 :
                    sb.append(stack.size());
                    sb.append('\n');
                    break;
                case 4 :
                    if (stack.isEmpty()){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append('\n');
                    break;
                case 5 :
                    if (!stack.isEmpty()){
                        if (stack.peek()>=0||stack.peek()<0){
                            sb.append(stack.peek());
                        }
                    }else{
                        sb.append(-1);
                    }
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
