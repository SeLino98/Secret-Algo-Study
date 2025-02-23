import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] list,tmpList;
    static int choiceCount;
    static int cardSize;
    public static void main(String[] args) throws IOException {
        cardSize = Integer.parseInt(br.readLine());
        choiceCount = Integer.parseInt(br.readLine());
        list = new int[cardSize];
        isVisited = new boolean[cardSize];
        hash = new HashSet<>();
        for (int i = 0; i < cardSize; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        tmpList = new int[choiceCount];
        combination(0);
        System.out.print(hash.size());
    }
    static boolean [] isVisited;
    static HashSet<Integer> hash;
    static void combination(int depth){
        if (depth == choiceCount){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmpList.length; i++) {
                sb.append(tmpList[i]);
            }
            int value = Integer.parseInt(sb.toString());
            hash.add(value);
            return;
        }
        for(int i = 0; i < list.length; i++){
            if (isVisited[i]) continue;
            isVisited[i] = true;
            tmpList[depth] = list[i];
            combination(depth+1);
            isVisited[i] = false;
        }
    }
}