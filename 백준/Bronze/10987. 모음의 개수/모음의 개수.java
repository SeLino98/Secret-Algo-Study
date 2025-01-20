import java.io.*;
import java.util.*;
public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [] wordList = {'a','e','i','o','u'};
    public static void main(String[] args) throws IOException{
        char [] nameTokenList = br.readLine().toCharArray();
        int answer = 0;
        for (int i = 0; i < nameTokenList.length; i++) {
            for (int j = 0; j < wordList.length; j++) {
                if (wordList[j] == nameTokenList[i]){
                    answer ++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}