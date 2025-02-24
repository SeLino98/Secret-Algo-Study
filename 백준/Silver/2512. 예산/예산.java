import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lt = 0;
        int rt = 0;
        int countLocalArea = Integer.parseInt(br.readLine());
        int [] listLocalArea = new int[countLocalArea];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countLocalArea; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            listLocalArea[i] =  tmp;
            rt = Math.max(tmp,rt);//지방 지역의 최대 예산 값 구하기
            lt = Math.min(tmp,lt);
        }
        int budget = Integer.parseInt(br.readLine());
        int answer = 0;
        while (lt<=rt){
            int mid = (rt+lt)/2;
            int tmpBudget = 0;
            for (int i = 0; i < listLocalArea.length; i++) {
                if (listLocalArea[i]>mid){
                    tmpBudget += mid;
                }else{
                    tmpBudget += listLocalArea[i];
                }
            }
            if (tmpBudget>budget){//가장 가까워질 때까지 반복
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
            answer = rt;
        }
        System.out.println(answer);
    }
}