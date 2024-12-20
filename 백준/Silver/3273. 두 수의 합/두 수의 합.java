import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int listSize = Integer.parseInt(br.readLine());
        int [] list = new int[listSize];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < listSize; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int findValue = Integer.parseInt(br.readLine());
        Arrays.sort(list);

        int lt = 0 ;
        int rt = list.length-1;
        int answer = 0;
        while (lt<rt){
            int tmpSum = list[rt]+list[lt];
            if (tmpSum<findValue){
                lt++;
            }else if(tmpSum>findValue){
                rt--;
            }else{//==
                answer++;
                lt++;
                rt--;
            }
        }
        System.out.print(answer);
    }
}
