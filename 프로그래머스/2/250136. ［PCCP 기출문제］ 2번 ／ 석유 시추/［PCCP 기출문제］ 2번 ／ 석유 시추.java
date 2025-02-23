import java.io.*;
import java.util.*;
class Solution {
    
    static int []dx = {1,0,-1,0};
    static int []dy = {0,1,0,-1};
    static int rowSize,colSize;
    static boolean [][] isVisitedMap;
    static int[][] cloneLand;
    static int[] saveOilList;
    static boolean[] isSaveOilList;
    
    public int solution(int[][] land) {
        rowSize = land.length;
        colSize = land[0].length;
        saveOilList = new int[colSize];
        isVisitedMap = new boolean[rowSize][colSize];
        cloneLand = land.clone();
        int answer = Integer.MIN_VALUE;
        //가로축으로 한번씩 시추해본다. 
        for(int c = 0; c < colSize; c++){
            int oilTotal = 0;
            for(int r = 0; r<rowSize; r++){
                if(isVisitedMap[r][c]) continue;
                if(cloneLand[r][c]==1){
                    isSaveOilList = new boolean[colSize];
                    oilTotal = BFS(r,c);
                    saveOilMap(oilTotal);
                }
            }
        }
        for(int token : saveOilList){
            answer = Math.max(token,answer);
        }
        return answer;
    }
    
    void saveOilMap(int oilValue){
        for(int i = 0; i<isSaveOilList.length; i++){
            if(isSaveOilList[i]) saveOilList[i] += oilValue;
        }
    }
    
    int BFS(int y, int x){
        int totalCount = 1; 
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{y,x});
        isVisitedMap[y][x] = true;
        isSaveOilList[x] = true;
        while(!q.isEmpty()){
            int []curPos = q.poll();
            for(int i = 0; i<4; i++){
                int nextY = curPos[0]+dy[i];
                int nextX = curPos[1]+dx[i];
                if(nextY>=0&&nextX>=0&&nextY<rowSize&&nextX<colSize){
                    if(isVisitedMap[nextY][nextX]) continue;
                    if(cloneLand[nextY][nextX]==1){
                        isVisitedMap[nextY][nextX] = true;
                        isSaveOilList[nextX] = true;
                        q.add(new int[]{nextY,nextX});
                        totalCount++;
                    }
                }
            }
        }
        return totalCount;
    }
}