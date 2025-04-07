import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> hamburgerList = new ArrayList<>();
        ArrayList<Integer> sideList = new ArrayList<>();
        ArrayList<Integer> cokeList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int minSet = 0;
        int maxSet = 0;
        int hamSize = Integer.parseInt(st.nextToken());
        int sideSize = Integer.parseInt(st.nextToken());
        int cokeSize = Integer.parseInt(st.nextToken());
        minSet = Math.min(hamSize, Math.min(sideSize, cokeSize));
        maxSet = Math.max(hamSize,Math.max(sideSize,cokeSize));
        st = new StringTokenizer(br.readLine());
        for (int h = 0; h < hamSize; h++) {
            int hamTmp = Integer.parseInt(st.nextToken());
            hamburgerList.add(hamTmp);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sideSize; i++) {
            int sideTmp = Integer.parseInt(st.nextToken());
            sideList.add(sideTmp);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cokeSize; i++) {
            int cokeTmp = Integer.parseInt(st.nextToken());
            cokeList.add(cokeTmp);
        }
        hamburgerList.sort(Collections.reverseOrder());
        sideList.sort(Collections.reverseOrder());
        cokeList.sort(Collections.reverseOrder());
        int beforeAnswer = 0;
        int answer = 0;
        int total = 0;
        for (int i = 0; i < minSet; i++) {
            total += hamburgerList.get(i)+cokeList.get(i)+sideList.get(i);
        }
        answer += total*0.9;
        beforeAnswer += total;
        for (int i = minSet; i < maxSet; i++) {
            if (hamSize>i){
                answer+=hamburgerList.get(i);
                beforeAnswer+=hamburgerList.get(i);
            }
            if (sideSize>i){
                answer+=sideList.get(i);
                beforeAnswer+=sideList.get(i);
            }
            if (cokeSize>i){
                answer += cokeList.get(i);
                beforeAnswer+=cokeList.get(i);
            }
        }
        System.out.println(beforeAnswer);
        System.out.print(answer);
    }
}
