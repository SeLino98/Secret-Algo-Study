import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    static HashSet<Integer> sheepHash ;
    static int answer;
    public static void main(String[] args) throws IOException {
        //양을 센다.
        //hash_set에 저장하고 끝날 때마다 확인한다. size로 체크
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        sheepHash = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= testCase; t++) {
            answer = Integer.parseInt(br.readLine());
            int value = answer;
            sheepHash.clear();
            int count = 1;
            while (true){
                String str = ""+answer;
                char[] list = str.toCharArray();
                for (char token : list) {
                    sheepHash.add(token-'0');
                }
                if (sheepHash.size()==10) break;
                count++;
                answer = value * count;
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
