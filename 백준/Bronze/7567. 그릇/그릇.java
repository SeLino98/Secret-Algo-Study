import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        char [] list = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 10;
        stack.add(list[0]);
        for (int i = 1; i < list.length; i++) {
            if (!stack.isEmpty()){
                if (stack.pop()==list[i]){
                    answer+= 5;
                } else{
                    answer+=10;
                }
            }
            stack.add(list[i]);
        }
        System.out.println(answer);
    }
}
