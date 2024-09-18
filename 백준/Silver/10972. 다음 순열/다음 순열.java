import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException {
        //이동 순열의 규칙??
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }//값이 다 들어감
        //1 뒤에서 내림차순이 끊기는 지점을 찾는다.
        if (N == 1){
            System.out.println(-1);
        }else{
            listFineFunc();
        }
    }
    static void listFineFunc(){
        int valueL = 0;
        int posL = 0;
        boolean flag = false;
        for (int i = N-1; i >= 0 ; i--) {
            if (i == 0){
                //맨 마지막 자리인 경우임
                flag = true;
                break;
            }
            if (list[i]>list[i-1]){
                valueL = list[i-1];
                posL = i-1;
                break;
            }
        }
        if (flag){
            System.out.println(-1);
        }else{
            //2. 뒤에서 부터 생성된 리스트중에서 끊기는 지점의 숫자보단 크지만 리스트에선 작은 수를 찾는다.
            int minValue = Integer.MAX_VALUE;
            int posR = 0;
            for (int i = N-1; i > posL ; i--) {
                if (valueL<list[i]&&minValue>list[i]){
                    minValue = list[i];
                    posR = i;
                }
            }
            //3. 그 수를 바꾼다.
            //swap
            int tmp = list[posL];
            list[posL] = list[posR];
            list[posR] = tmp;
            //4. 생성된 리스트도 역순으로 한다.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= posL; i++) {
                sb.append(list[i]).append(" ");
            }
            for (int i = N-1; i >posL; i--) {
                sb.append(list[i]).append(" ");
            }
            //답을 출력한다.
            System.out.println(sb.toString().trim());
        }
    }
}
