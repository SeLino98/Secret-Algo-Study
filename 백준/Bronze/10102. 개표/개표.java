import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        char [] list = br.readLine().toCharArray();
        int aCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < total; i++) {
            if (list[i]=='A'){
                aCnt++;
            }else{
                bCnt++;
            }
        }
        if (aCnt>bCnt){
            System.out.println("A");
        }else if (bCnt>aCnt){
            System.out.println("B");
        }else{
            System.out.println("Tie");
        }
    }
}
