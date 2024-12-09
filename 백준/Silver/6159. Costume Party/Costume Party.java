import java.util.*;
import java.io.*;
public class Main {
    static int cowsLength,cowsCount;
    static int [] cowsList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        cowsCount = Integer.parseInt(st.nextToken());
        cowsLength = Integer.parseInt(st.nextToken());
        cowsList = new int[cowsCount];
        for (int i = 0; i < cowsCount; i++) {
            cowsList[i] = Integer.parseInt(br.readLine());
        }
        //정렬하고
        Arrays.sort(cowsList);
        int answer = cal();
        System.out.println(answer);
    }
    // 6
    // 1 2 3 5
    static int cal(){
        int answer = 0;
        for (int i = 0; i < cowsList.length-1; i++) {
            for (int j = i+1; j < cowsList.length; j++) {
                int tmp = cowsList[i]+cowsList[j];
                if (tmp<=cowsLength){
                    answer++;
                }else if(tmp>cowsLength){
                    break;
                }
            }
        }
        return answer;
    }
}