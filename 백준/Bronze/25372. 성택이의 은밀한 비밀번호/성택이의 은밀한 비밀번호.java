import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            char [] tmpList = br.readLine().toCharArray();
            String answer ;
            int tmpSize = tmpList.length;
            if (tmpSize>=6&&tmpSize<=9){
                answer = "yes";
            }else{
                answer = "no";
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
