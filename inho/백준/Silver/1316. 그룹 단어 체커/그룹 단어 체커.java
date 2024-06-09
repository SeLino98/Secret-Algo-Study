import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int answerCount = 0;
        for (int t = 0; t < testCase; t++) {
            HashSet<Character> hash =  new HashSet<>();
            char[]list = br.readLine().toCharArray();
            char firstWord = list[0];
            hash.add(firstWord);
            boolean isFlag = true;
            for (int i = 1; i < list.length; i++) {
                if (list[i-1]!=list[i]){
                    if (hash.contains(list[i])){
                        isFlag = false;
                        break;
                    }else{
                        hash.add(list[i]);
                    }
                }
            }
            if (isFlag) answerCount++;
        }
        System.out.print(answerCount);
    }
}
