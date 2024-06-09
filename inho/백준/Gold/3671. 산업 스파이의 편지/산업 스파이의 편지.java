import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
public class Main {
    static boolean[] isVisited ;
//    static boolean[] isPrime;
    static HashSet<Integer> targets;
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        isPrime = new boolean[10_000_000+1];//100,000
//        for (int i = 2; i <= Math.sqrt(10_000_000)+1 ; i++) {
//            if (isPrime[i]) continue;;
//            for (int j = i+i; j <= 10_000_000; j+=i) {
//                isPrime[j] = true; //소수가 아니면 트루로 체크한다.
//            }
//        }
//        isPrime[0] = true;
//        isPrime[1] = true;
        int testCase = Integer.parseInt(br.readLine());
        targets = new HashSet<>();
        for (int t = 1; t <= testCase; t++) {
            char[] charList = br.readLine().toCharArray();
            answerCount = 0;
            int size = charList.length;
//            for (int i = 0; i < size; i++) {
//                findMaxValue.add(charList[i]-'0'); //7자리
//            }
//            Collections.sort(findMaxValue,Collections.reverseOrder());
//            String maxValueString = "";
//            for (int i = 0; i < findMaxValue.size(); i++) {
//                maxValueString += findMaxValue.get(i);
//            }
//            int maxValue = Integer.parseInt(maxValueString);
//            if (maxValue==1||maxValue==0){
//                bw.write(0+"\n");
//                continue;
//            }
            targets.clear();
            for (int depth = 0; depth < size; depth++) { // 7번
                isVisited = new boolean[size+1]; //
                Combination(0,depth+1,charList, new char[depth+1]);
            }
            for (Integer token : targets
            ) {
                if (isPrime(token)){
//                    System.out.println(token);
                    answerCount++;
                }
            }
            bw.write(answerCount+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int answerCount ;
    static void Combination(int depth,int maxDepth,char [] list,char [] bowlList){
        if (depth==maxDepth){
            String maxValueString = "";
            for (int i = 0; i < bowlList.length; i++) {
                maxValueString += bowlList[i];
            }
//            System.out.println("maxV"+maxValueString);
            int value = Integer.parseInt(maxValueString);
            targets.add(value);

//            System.out.println(value);
            return;
        }
        for (int i = 0; i < list.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            bowlList[depth] = list[i];
            Combination(depth+1,maxDepth,list,bowlList);
            isVisited[i] = false;
        }
    }
}


//public class Main {
//    static int N;
//    static char[][] picture;
//    static char[][] pictureByRG;
//    static boolean[][] visit;
//    static int[] dx = {-1, 1, 0, 0};static int[] dy = {0, 0, -1, 1};
//    public static void main(String[] args) throws IOException {
//        input();
//        solve();
//    }
//    private static void solve() {
//        // 일반인
//        int generalCount = 0;
//        visit = new boolean[N][N];
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                if(!visit[i][j]) {
//                    bfs(picture, i, j);
//                    generalCount++;
//                }
//            }
//        }
//
//        // 적록 색약
//        int redgreenCount = 0;
//        visit = new boolean[N][N];
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                if(!visit[i][j]) {
//                    bfs(pictureByRG, i, j);
//                    redgreenCount++;
//                }
//            }
//        }
//        System.out.println(generalCount+" "+redgreenCount);
//    }
//    private static void bfs(char[][] picture, int i, int j) {
//        char color = picture[i][j];
//        Queue<Point> q = new ArrayDeque<>();
//        q.offer(new Point(i, j));
//
//        while(!q.isEmpty()) {
//            Point p = q.poll();
//            visit[p.x][p.y] = true;
//            for(int d=0; d<4; d++) {
//                int nx = p.x+dx[d];
//                int ny = p.y+dy[d];
//                if(nx>=0 && nx<N && ny>=0 && ny<N
//                        && !visit[nx][ny] && picture[nx][ny]==color) {
//                    q.offer(new Point(nx, ny));
//                }
//            }
//        }
//
//    }
//    private static void input() throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        picture = new char[N][N];
//        pictureByRG = new char[N][N];
//        for(int i=0; i<N; i++) {
//            picture[i] = br.readLine().toCharArray();
//            pictureByRG[i] = picture[i].clone();
//            for(int j=0; j<N; j++)
//                if(pictureByRG[i][j]=='G')
//                pictureByRG[i][j]='R';
//        }
//
//    }
//    static class Point{
//        int x; int y;
//        public Point(int x, int y) {this.x=x; this.y=y;}
//    }
//
//}

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Main {
//    static int []dx ={1,0,-1,0};
//    static int []dy ={0,1,0,-1};
//
//    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st = new StringTokenizer(br.readLine());
//        String[][] place = {
//                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
//        solution(place);
//
//    }
//    public static void recurseSimulation(int depth, int yPos, int xPos,char[][]map){
//        //깊이를 2로 잡고 탐색을 실시한다./?
//        //깊이가 2이하인데
//        //x이면 막힌 곳이니 더 안가도 됨. 종료
//        //p이면 1리턴
//        //만일 o라면 빈좌석이니 다음 깊이로 넘어가서 p가 있는지 확인한다.
//        if (depth>=2) return ;
//        isVisited[yPos][xPos] = true;
//        for (int i = 0; i < 4; i++) {
//            int nx = dx[i]+xPos;
//            int ny = dy[i]+yPos;
//            if (nx>=0&&ny>=0&&nx<5&&ny<5&&!isVisited[ny][nx]){
//                if (map[ny][nx]=='P'){
//                    isDanger = true;
//                    return;
//                }else if(map[ny][nx]=='O'){
//                    isVisited[ny][nx] = true;
//                    recurseSimulation(depth+1,ny,nx,map);
//                    isVisited[ny][nx] = false;
//                }
//            }
//        }
//    }
//    static ArrayList<int[]> personList;
//    static boolean [][]isVisited;
//    static boolean isDanger;
//    public static int[] solution(String[][] places) {
//        int[] answer = new int[5];
//        for (int i = 0; i < 5; i++) {
//            char [][]map= new char[5][5];
//            personList = new ArrayList<>();
//            for (int j = 0; j < 5; j++) {
//                map[j] = places[i][j].toCharArray();
//            }
//            for (int j = 0; j < 5; j++) {
//                for (int k = 0; k < 5; k++) { // 전체를 돌면서 해당 위치의 배열 자리를 잡는다.
//                    if (map[j][k]=='P'){
//                        personList.add(new int[]{j,k});
//                    }
//                }
//            }
//            for (int j = 0; j < personList.size(); j++) {//사람 위치가 저장된 배열을 순회하면서 재귀를 돌린다.
//                int[] xyPos = personList.get(j);
//                isVisited = new boolean[5][5];
//                isDanger = false;
//                recurseSimulation(0,xyPos[0],xyPos[1],map);
//                if (isDanger){
//                    break;
//                }
//            }
//            if (isDanger){
//                answer[i] = 0;
//            }else{
//                answer[i] = 1;
//            }
////            for (int j = 0; j < 5; j++) {
////                for (int k = 0; k < 5; k++) {
////                    System.out.print(map[j][k]+" ");
////                }
////                System.out.println();
////            }
////            System.out.println();
//        }
//        for (int i = 0; i < 5; i++) {
//            System.out.print(answer[i]+" ");
//        }
//
//        return answer;
//    }
//}