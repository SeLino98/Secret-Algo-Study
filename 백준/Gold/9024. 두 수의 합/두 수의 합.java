import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int testCase;
    static StringTokenizer st ;
    static int findNum,listSize;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t<testCase; t++){
            st = new StringTokenizer(br.readLine());
            listSize = Integer.parseInt(st.nextToken());
            findNum = Integer.parseInt(st.nextToken());
            int [] list = new int[listSize];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < list.length; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            //정렬
            Arrays.sort(list);
            int minGap = Integer.MAX_VALUE;
            //두 포인터를 사용하여 갱신
            //이때 최소값이 갱신되면 count 초기화
            int lt = 0;
            int rt = list.length-1;
            int answerCount = 0;
            while (lt<rt){
                int tmpValue = list[lt] + list[rt];
                int tmpGap = Math.abs(findNum-tmpValue);
                if (tmpGap<minGap){//tmpGap의 최소는 0
                    minGap = tmpGap;
                    answerCount = 1;
                }else if (tmpGap == minGap){
                    answerCount++;
                }
                if (tmpValue>findNum){
                    rt--;
                }else{
                    lt++;
                }
            }
            bw.write(answerCount+"\n");
        }//testCase
        br.close();
        bw.flush();
        bw.close();
    }//main
}
