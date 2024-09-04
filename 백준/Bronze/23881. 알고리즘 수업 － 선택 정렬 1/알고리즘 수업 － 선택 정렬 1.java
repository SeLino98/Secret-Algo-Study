import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int kCount = 0;
        int [] list = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            list[i]= Integer.parseInt(st.nextToken());
        }
        int swapTmp = 0;
        int tmpPos = 0;
        for (int i = 0; i < size; i++) {
            int max = Integer.MIN_VALUE;
            if (k==kCount){
                break;
            }
            for (int j = 0; j < size-i; j++) {
                if (max<list[j]){
                    max = list[j];
                    tmpPos = j;
                }
            }
            //swap
            swapTmp = size-i-1;
            int tmp = list[swapTmp];
            if (list[swapTmp]==list[tmpPos]){
            }else{
                kCount++;
                list[swapTmp] = list[tmpPos];
                list[tmpPos] = tmp;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (k>kCount){
            sb.append(-1);
        }else{
            sb.append(list[tmpPos]).append(" ").append(list[swapTmp]);
        }
        System.out.print(sb);
    }
}
