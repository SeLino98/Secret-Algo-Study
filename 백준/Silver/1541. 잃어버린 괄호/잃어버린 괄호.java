import java.util.*;
import java.io.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        // - 기준으로 -가 나오거나 끝까지 배열이 갈 때까지 묶어서 더 한다.
        // 그 담에 연산

        String formWord = br.readLine();
        String [] minusBundleWordList = formWord.split("-");
        int answer = 0;
        for (int i = 0; i < minusBundleWordList.length; i++) {
            int tmpValue = 0;
            String [] plusBundleWordList = minusBundleWordList[i].split("\\+");
            for (String value : plusBundleWordList) {
                tmpValue += Integer.parseInt(value);
            }
            if (i==0){
                answer+=tmpValue;
            }else{
                answer-=tmpValue;
            }
        }
        System.out.print(answer);
    }
}
