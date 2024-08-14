import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스네이크_실버 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fruitCnt = Integer.parseInt(st.nextToken());
        int firstLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        int [] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        for(int i=0;i<size;i++){
            if(firstLength >= list[i])	//스네이크버드 길이보다 작거나 같으면 과일 섭취
                firstLength++;	//길이 증가
        }
        System.out.println(firstLength);
    }
}