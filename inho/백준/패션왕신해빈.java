import java.io.*;
import java.util.*;
public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int wearAmount = Integer.parseInt(br.readLine());
            HashMap<String,Integer> hash = new HashMap<>();
            for (int i = 0; i < wearAmount; i++) {//해시로 값을 받는데, 같은 해시 값일 경우 카운트 하기.
                String [] tmp = br.readLine().split(" ");
                if (hash.containsKey(tmp[1])){
                    int getCount = hash.get(tmp[1]);
                    hash.replace(tmp[1],getCount+1);
                }else{
                    hash.put(tmp[1],1);
                }
            }
            //해시로 입력을 다 받았다면
            //전체 갯수에서 하나도 안 입은 경우의 수 (1)을 빼주기
            int answer = 1;
            for(int token : hash.values()){
                answer *= (token+1);
            }
            sb.append(answer-1).append('\n');
            //종류의 갯수만큼 돌리기
        }
        System.out.print(sb);
    }
}
