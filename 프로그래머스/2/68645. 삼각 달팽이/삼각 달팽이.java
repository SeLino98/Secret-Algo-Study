class Solution {
    public int[] solution(int n) {
       int [][]map = new int[n][n];
        int type = 0;
        int posN = 0;
        int posX = 0;
        int posY = 0;
        int score = 0;
        map[0][0] = 1;
        while(n!=posN){
            int result = type%3;
//            System.out.println(result);
//            System.out.println("posN: "+ posN);
            switch (result){
                case 0://내려가기
                    for (int i = 0; i < n-posN; i++) {
                        map[posY++][posX] = ++score;
                        //System.out.println("ASDF");
                    }
                    posX++;
                    posY--;
                    break;
                case 1://옆으로 가기
//                    System.out.println(posY +"Y"+posX+"X");
                    for (int i = 0; i < n-posN; i++) {
                        map[posY][posX] = ++score;
//                        System.out.print(map[posY][posX]+ " ");
                        posX++;
                    }
                    posX--;
                    posX--;
                    posY--;
                    break;
                case 2://대각선 위로
                    for (int i = 0; i < n-posN; i++) {
                        map[posY][posX] = ++score;
                        posX--;
                        posY--;
                    }
                    posX++;
                    posY++;
                    posY++;
                    break;
            }
            type++;
            posN++;
        }
        int mapSize = 0;
        for (int i = 0; i <= n; i++) {
            mapSize += i;
        }
        int [] answer = new int[mapSize];
        int step = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i<j) continue;
                answer[step++] = map[i][j];
                // System.out.print(map[i][j]+" ");
            }
            // System.out.println();
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
    
}