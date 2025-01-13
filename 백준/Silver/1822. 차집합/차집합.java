import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < aSize; i++) {
//            aSet.add();
            aList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(aList);
        Set<Integer> bSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int token: aList
             ) {
            if (!bSet.contains(token)) answerList.add(token);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answerList.size()).append('\n');
        for (int answerToken:answerList
             ) {
            sb.append(answerToken).append(" ");
        }
        System.out.print(sb);
    }
}
