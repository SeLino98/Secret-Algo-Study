import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][]map ;
    static int mapSize;
    static int [] bodyInfoList = new int[5];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        mapSize = Integer.parseInt(br.readLine());
        map = new boolean[mapSize][mapSize];
        char [] tmpList ;
        for (int i = 0; i < mapSize; i++) {//입력 받고 저장한다.
            tmpList = br.readLine().toCharArray();
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = tmpList[j] == '*';
            }
        }
        //맵을 순서대로 돌리는데 먼저 걸리는 게 머리
        //걸리는 순간 밑으로 내려가 심장을 찾고 탐색을 들어간다.
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j]) {
                    findHeart(i,j);
                    printAnswer();
                    return;
                }
            }
        }
        //하반신의 경우 밑으로 가다 없으면 그 한칸 더 밑으로 내려간 뒤
        //아래 방향으로 탐색을 진행한다.

        // 출력
        // 심장 좌표
        // 왼쪽 팔, 오른족 팔, 왼쪽 다리 오른쪽 다리
    }
    static void printAnswer(){
        for (int token: bodyInfoList) {
            sb.append(token).append(" ");
        }
        System.out.print(sb);
    }
    static void updateBodyInfoList(int num){
        bodyInfoList[num]++;
    }
    static void findHeart(int y, int x){
        sb.append(y+2).append(" ").append(x+1).append("\n");
        findLeftArms(y+1,x-1);
        findRightArms(y+1,x+1);
        findSpine(y+2,x);
    }
    static void findLeftArms(int y, int x){
        if (isTrueAndBoundaryCheck(y,x)){
            updateBodyInfoList(0);
            findLeftArms(y,x-1);
        }
        return;
    }
    static void findRightArms(int y, int x){
        if (isTrueAndBoundaryCheck(y,x)){
            updateBodyInfoList(1);
            findRightArms(y,x+1);
        }
        return;
    }
    static void findSpine(int y, int x){
        if (isTrueAndBoundaryCheck(y,x)){
            updateBodyInfoList(2);
            findSpine(y+1,x);
        }else{
            findLeftLegs(y,x-1);
            findRightLegs(y,x+1);
        }
        return;
    }
    static void findLeftLegs(int y, int x){
        if (isTrueAndBoundaryCheck(y,x)){
            updateBodyInfoList(3);
            findLeftLegs(y+1,x);
        }
        return;
    }
    static void findRightLegs(int y, int x){
        if (isTrueAndBoundaryCheck(y,x)){
            updateBodyInfoList(4);
            findRightLegs(y+1,x);
        }
        return;
    }
    static boolean isTrueAndBoundaryCheck(int y, int x){
        if (x>=0&&y>=0&&x<mapSize&&y<mapSize&&map[y][x]){
            return true;
        }
        return false;
    }
}
