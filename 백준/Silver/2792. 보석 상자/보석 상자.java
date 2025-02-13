import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] gems;
    static int countOfChild,kindOfGemSize;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        countOfChild = Integer.parseInt(st.nextToken());
        kindOfGemSize = Integer.parseInt(st.nextToken());

        gems = new int[kindOfGemSize];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < kindOfGemSize; i++) {
            gems[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, gems[i]);
        }

        int lt = 1;
        int rt = maxValue;
        int mid = 0;
        int answer = (lt+rt)/2;
        while (lt<=rt){
            mid = (lt+rt)/2;
            if (isDistribute(mid)){//더 분배해줘야 하는 경우
                answer = mid;
                rt = mid-1;
            }else{ // 분배된 인원 수가 많은 경우
                lt = mid+1;
            }
        }
        System.out.print(answer);
    }
    static boolean isDistribute(int gemLoaf){
        int divChildCount = 0;
        for (int token : gems) {
            divChildCount += token/gemLoaf;
            if (token%gemLoaf!=0) divChildCount++;
        }
        return divChildCount<=countOfChild;//적다면? 아직 보석 못 받은 애들이 있단 뜻 더 돌아야 됨.
    }
}
