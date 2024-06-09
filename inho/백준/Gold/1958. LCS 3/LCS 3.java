import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char [] xList = br.readLine().toCharArray();
        char [] yList = br.readLine().toCharArray();
        char [] zList = br.readLine().toCharArray();
        int ySize = yList.length+1;//0때매 있어야 됨
        int xSize = xList.length+1;//0때매 있어야 됨
        int zSize = zList.length+1; //여기 0좌표엔 2차원 배열의 값이 있어야 됨.
        int[][][]strSizeMap = new int[ySize][xSize][zSize];
        for (int y = 1; y < ySize; y++) {
            for (int x = 1; x < xSize; x++) {
                //2차원 배열에 저장하는 방법.
                for (int z = 1; z < zSize; z++) {
                    if (xList[x-1]==zList[z-1]&&yList[y-1]==xList[x-1]){
                        strSizeMap[y][x][z] =1+strSizeMap[y-1][x-1][z-1];
                    }else{
                        strSizeMap[y][x][z] = Math.max(strSizeMap[y][x][z-1],Math.max(strSizeMap[y-1][x][z],strSizeMap[y][x-1][z]));
                    }
                }
            }
        }
        System.out.println(strSizeMap[ySize-1][xSize-1][zSize-1]);

        //그래프를 저장하는 방법
        //배열 저장//리스트 저장
    }
}
