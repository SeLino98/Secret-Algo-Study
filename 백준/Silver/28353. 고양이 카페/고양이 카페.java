import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfCat = Integer.parseInt(st.nextToken());
        int maxOfWeight = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] catList = new int[numberOfCat];

        for (int i = 0; i < catList.length; i++) {
            catList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(catList);

        int rt = catList.length-1;
        int lt = 0;
        int answer = 0;
        while (lt<rt){
            int tmp = catList[rt]+catList[lt];
            if (tmp>maxOfWeight){
                rt--;
            }else{
                answer++;
                lt++;
                rt--;
            }

        }
        System.out.print(answer);
    }
}

//1 lt , rt 양 끝지점
// 작아지는 순간 lt, rt ++ --
//종료 시점은 만나는 시점.
