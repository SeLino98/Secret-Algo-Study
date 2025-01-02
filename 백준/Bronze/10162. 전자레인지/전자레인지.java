import java.io.*;
import java.util.*;
public class Main {
    static int [] list = {300,60,10};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cookTime = Integer.parseInt(br.readLine());
        if (cookTime%10!=0){
            System.out.print(-1);
            return;
        }
        int [] timeList = new int[3];
        for (int i = 0; i < timeList.length; i++) {
            timeList[i] = cookTime/list[i];
            cookTime = cookTime%list[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int j : timeList) {
            sb.append(j).append(" ");
        }
        System.out.print(sb);
    }
}
