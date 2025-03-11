import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [] ucpcList = {'U','C','P','C'};
    final static int ucpcWordSize = 4;
    public static void main(String[] args) throws IOException {
        char [] list = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int jPos = 0;
        for (int i = 0; i < list.length; i++) {
            if (Character.isUpperCase(list[i])){
                if (list[i]==ucpcList[jPos]){
                    jPos += 1;
                    sb.append(list[i]);
                }
            }
            if (jPos==ucpcWordSize){
                break;
            }
        }
        if (sb.toString().equals("UCPC")){
            System.out.print("I love UCPC");
        }else{
            System.out.print("I hate UCPC");
        }
    }
}
