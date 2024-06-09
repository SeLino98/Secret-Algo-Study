import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static int []dx ={1,0,-1,0};
    static int []dy ={0,1,0,-1};
   public static void recurseSimulation(int depth, int yPos, int xPos,char[][]map){
        //깊이를 2로 잡고 탐색을 실시한다./?
        //깊이가 2이하인데
        //x이면 막힌 곳이니 더 안가도 됨. 종료
        //p이면 1리턴
        //만일 o라면 빈좌석이니 다음 깊이로 넘어가서 p가 있는지 확인한다.
        if (depth>=2) return ;
        isVisited[yPos][xPos] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i]+xPos;
            int ny = dy[i]+yPos;
            if (nx>=0&&ny>=0&&nx<5&&ny<5&&!isVisited[ny][nx]){
                if (map[ny][nx]=='P'){
                    isDanger = true;
                    return;
                }else if(map[ny][nx]=='O'){
                    //isVisited[ny][nx] = true;
                    recurseSimulation(depth+1,ny,nx,map);
                    //isVisited[ny][nx] = false;
                }else if(map[ny][nx]=='X'){
                    continue;
                }
            }
        }
    }
    static ArrayList<int[]> personList;
    static boolean [][]isVisited;
    static boolean isDanger;
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            char [][]map= new char[5][5];
            personList = new ArrayList<>();
            isDanger = false;
            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) { // 전체를 돌면서 해당 위치의 배열 자리를 잡는다.
                    if (map[j][k]=='P'){
                        personList.add(new int[]{j,k});
                    }
                }
            }
            for (int j = 0; j < personList.size(); j++) {//사람 위치가 저장된 배열을 순회하면서 재귀를 돌린다.
                int[] xyPos = personList.get(j);
                isVisited = new boolean[5][5];
               
                recurseSimulation(0,xyPos[0],xyPos[1],map);
                if (isDanger){
                    break;
                }
            }
            if (isDanger){
                answer[i] = 0;
            }else{
                answer[i] = 1;
            }
//            for (int j = 0; j < 5; j++) {
//                for (int k = 0; k < 5; k++) {
//                    System.out.print(map[j][k]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(answer[i]+" ");
        }

        return answer;
    }
}