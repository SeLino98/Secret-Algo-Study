import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] list = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if((i+1)%10==0 && i != 0){
                sb.append(list[i]);
                sb.append("\n");
            }else{
                sb.append(list[i]);
            }
        }
        System.out.println(sb.toString());
    }
}