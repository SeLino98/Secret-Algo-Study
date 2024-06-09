import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int findNum = Integer.parseInt(br.readLine());
        int answerCount = 0;
        for (Integer token: list
             ) {
            if (token==findNum){
                answerCount++;
            }
        }
        System.out.println(answerCount);
    }
}