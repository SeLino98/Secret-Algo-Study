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
        int startY = rowSize-2; //str1
        int startX = colSize-2; // str2
        StringBuilder answerSb = new StringBuilder();
        while (true){
            //0을 만나면 종료
            if (str1[startY]==str2[startX]){
                answerSb.append(str1[startY]);
                startX-=1;
                startY-=1;
            }else{//다를 경우
                //다른데 같거나 클 경우
                if (map[startY+1][startX]>=map[startY][startX+1]){
                    startX-=1;
                }else{
                    startY-=1;
                }
            }
            if (startY<0||startX<0||startY>str1.length||startX>str2.length){
                break;
            }
        }
        answerSb.reverse();
        System.out.println(answerSb.length());
        if (answerSb.length()==0){
            System.out.println();
        }else{
            System.out.println(answerSb);
        }
    }
}
