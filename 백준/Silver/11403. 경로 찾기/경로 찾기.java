import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int mapSize;
    public static void main(String[] args) throws IOException {
        mapSize = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][]map = new int[mapSize][mapSize];
        for (int r = 0; r < mapSize; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < mapSize; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < mapSize; k++) {
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    if (map[k][j]==1&&map[i][k]==1){
                        map[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}