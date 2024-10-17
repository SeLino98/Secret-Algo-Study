import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] wordList = br.readLine().toCharArray();
        int count = 1;
        for (int i = 1; i < wordList.length; i++) {
            if (wordList[i-1]!= wordList[i]){
                count++;
            }
        }
        int answer = count/2;
        System.out.println(answer);
    }
}