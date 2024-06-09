import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second =Integer.parseInt(st.nextToken());
            if (first==0&&second==0){
                break;
            }
            int answer = second&first;
            boolean flag = false;
            boolean isAnswer = false;
            if (first<second){
                isAnswer = function(first,second);
            }else if (second<first){
                flag = true;
                isAnswer = function(second,first);
            }
            if (isAnswer&&flag){
                sb.append("multiple").append("\n");
            }else if (isAnswer){
                sb.append("factor").append("\n");
            }else{
                sb.append("neither").append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static boolean function(int value, int maxValue){
        if (value == 1) return true;
        if (maxValue%value == 0) return true;
        return false;
    }
}
