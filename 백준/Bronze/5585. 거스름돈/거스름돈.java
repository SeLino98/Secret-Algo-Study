import java.io.*;
public class Main {
    static int [] payList = {500,100,50,10,5,1};
    final static int listLength = payList.length;
    static int [] changePayList = new int[listLength];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tmp = 1000 - Integer.parseInt(br.readLine());
        for (int i = 0; i < listLength; i++) {
            changePayList[i] = tmp/payList[i];
            tmp = tmp%payList[i];
        }
        int answer = 0;
        for (int i = 0; i < listLength; i++) {
            answer += changePayList[i];
        }
        System.out.print(answer);
    }
}
