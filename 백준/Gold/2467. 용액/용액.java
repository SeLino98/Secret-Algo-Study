import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int[] list = new int[arrSize];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i<arrSize; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        //정렬한다.
        Arrays.sort(list);

        //-99 -2 -1 4 98
        //두 값을 더했을 때 마이너스면? 마이너스를 올리는 포인터 이동
        //더했을 때 양수이면 양수 값을 내려서 마이너스로 맞춘다,
        // 이 때 최소지점이 되는 점은 매번 갱신해서 두 값을 저장해둔다.
        int [] answerPos = new int[2];
        int lt =0 ;
        int rt = arrSize-1;
        int minValue = Integer.MAX_VALUE;
        while (lt<rt){
            int sum = list[lt] + list[rt];
            int absSum = Math.abs(sum);
            if (minValue>=absSum){
                answerPos[0] = list[lt];
                answerPos[1] = list[rt];
                minValue = absSum;
            }
            if (sum<0){
                lt++;
            }else{
                rt--;
            }
        }
        sb.append(answerPos[0]).append(" ").append(answerPos[1]).append("\n");

        System.out.print(sb);
        br.close();
    }

}
