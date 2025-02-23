import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {

        int movieNum = Integer.parseInt(br.readLine());
        int startNumber = 666;
        int curPos = 0;
        while (true){
            String tmpList = String.valueOf(startNumber);
            char [] list = tmpList.toCharArray();
            int sixCount = 0;
            boolean isThreeSixMovie = false;
            for (char token: list
                 ) {
                if (token == '6'){
                    sixCount++;
                }else{
                    sixCount = 0;
                }
                if (sixCount>=3){
                    isThreeSixMovie = true;
                    break;
                }
            }
            if (isThreeSixMovie){
                curPos++;
            }
            if (curPos == movieNum) break;
            startNumber++;
        }
        System.out.print(startNumber);
    }
}
