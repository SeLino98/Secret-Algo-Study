
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int [] arr = new int[n];
        int [] answer = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i<n; i++){
            while (!stack.empty() && arr[stack.peek()]<arr[i]) {
                   answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.empty()){
            answer[stack.pop()] = -1;

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<n; i++){
            bw.write(answer[i]+" ");

        }
        bw.write("\n");
        bw.flush();





    }
}
