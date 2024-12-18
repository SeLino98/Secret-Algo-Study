import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        int listSize, findValue ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        listSize = Integer.parseInt(st.nextToken());
        findValue = Integer.parseInt(st.nextToken());
        int [] list = new int[listSize];//1 5 3
        for (int i = 0; i < listSize; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        if (list.length== 1){
            System.out.print(0);
            return;
        }
        Arrays.sort(list);
        int lt = 0;
        int rt = 1;
        int answer = Integer.MAX_VALUE;
        while (rt < listSize &&lt<rt){
            int tmp = list[rt] - list[lt];
            if (findValue == tmp){
                answer = tmp;
                break;
            }
            if (tmp>findValue){
                answer = Math.min(answer,tmp);
                lt++;
            }else{
                rt++;
            }
            if (lt == rt) rt++;

        }
        System.out.print(answer);
    }
}
