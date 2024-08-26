import java.io.*;
import java.util.*;
public class Main {
    static int [] wordList = {1,5,10,50};
    static int limitedCount = 0;
    static final int wordListSize = wordList.length;
    public static void main(String[] args) throws IOException {
        //중복 조합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        limitedCount = Integer.parseInt(br.readLine());
        combination(0,0,0);
        System.out.println(answerHash.size());
    }
    static HashSet<Integer> answerHash = new HashSet<>();
    static void combination(int idx, int depth, int value){
        if (depth==limitedCount){
            //특정 갯수만큼 돌면
            //해쉬로 저장
            answerHash.add(value);
            return;
        }
        for (int i = idx; i < wordListSize; i++) {
            value += wordList[i];
            combination(i, depth+1, value);
            value -= wordList[i];
        }
    }
}
