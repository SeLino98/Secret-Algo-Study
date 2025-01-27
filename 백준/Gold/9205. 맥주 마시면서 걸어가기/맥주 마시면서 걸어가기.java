import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static StringBuilder sb = new StringBuilder();
    static int []startXY = new int[2];
    static int []endXY = new int[2];
    static int [][] storeXY ;
    static int storeSize ;
    static boolean [] isVisitedStoreList;
    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            inputAndSettingData();
            outputStringBuilder();
        }
        System.out.print(sb);
    }
    static boolean BFS(int [] startXY, int storeSize){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startXY[0],startXY[1]});
        while (!q.isEmpty()){
            int []posXY = q.poll();
            if (manhattanDistance(endXY,posXY)){
                return true;
            }
            for (int i = 0; i < storeSize; i++) {
                if (isVisitedStoreList[i]) continue;
                int [] nXY = storeXY[i];
                if (manhattanDistance(nXY,posXY)){
                    isVisitedStoreList[i] = true;
                    q.add(new int[]{nXY[0],nXY[1]});
                }
            }
        }
        return false;
    }
    static void inputAndSettingData() throws IOException{
        storeSize = Integer.parseInt(br.readLine());
        storeXY = new int[storeSize][2];
        st = new StringTokenizer(br.readLine());
        startXY[0] = Integer.parseInt(st.nextToken());
        startXY[1] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < storeSize; i++) {
            st = new StringTokenizer(br.readLine());
            storeXY[i][0] = Integer.parseInt(st.nextToken());
            storeXY[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        endXY[0] = Integer.parseInt(st.nextToken());
        endXY[1] = Integer.parseInt(st.nextToken());
        isVisitedStoreList = new boolean[storeSize];
    }
    static void outputStringBuilder(){
        sb.append(BFS(startXY,storeSize) ? "happy": "sad").append('\n');
    }
    static boolean manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1])<=1000;
    }
}
