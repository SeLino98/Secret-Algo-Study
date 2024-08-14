import java.io.*;
import java.util.*;
public class Main {
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
            if(firstLength >= list[i])
                firstLength++;	//길이 증가
        }
        System.out.println(firstLength);
    }
}