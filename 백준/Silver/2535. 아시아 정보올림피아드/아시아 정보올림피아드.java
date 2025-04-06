import java.io.*;
import java.util.*;
class ProPerson implements Comparable<ProPerson>{
    int countryNum = 0;
    int idx = 0;
    int score = 0;
    public ProPerson(int countryNum, int idx, int score) {
        this.countryNum = countryNum;
        this.idx = idx;
        this.score = score;
    }
    @Override
    public int compareTo(ProPerson o) {
        return o.score - this.score;
    }
}
public class Main {
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        ArrayList<ProPerson> list = new ArrayList<>();
        int maxValue = 0;
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            int countryNum = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list.add(new ProPerson(countryNum,idx,score));
            maxValue = Math.max(maxValue,countryNum);
        }
        Collections.sort(list);
        int [] dupCountList = new int[maxValue+1];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (count == 3) break;
            int countryNum = list.get(i).countryNum;
            int idx = list.get(i).idx;
            if (dupCountList[countryNum]<2){
                sb.append(countryNum).append(" ").append(idx).append('\n');
                dupCountList[countryNum]++;
                count++;
            }
        }
        System.out.print(sb);
    }
}
