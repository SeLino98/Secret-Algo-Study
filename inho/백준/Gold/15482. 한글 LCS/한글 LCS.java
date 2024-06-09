import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] str1 = br.readLine().toCharArray();
        char [] str2 = br.readLine().toCharArray();
        int rowSize = str1.length+1;
        int colSize = str2.length+1;//인덱스범위를 넘기지 않게 하기 위함.
        map = new int[rowSize][colSize];
        for (int r = 1; r < rowSize; r++) {
            for (int c = 1; c < colSize; c++) {
                int strRow = r-1;
                int strCol = c-1;
                if (str1[strRow]==str2[strCol]){
                    map[r][c] = 1+map[r-1][c-1];
                }else{
                    map[r][c] = Math.max(map[r-1][c],map[r][c-1]);
                }
            }
        }
        System.out.print(map[rowSize-1][colSize-1]);
    }
}
