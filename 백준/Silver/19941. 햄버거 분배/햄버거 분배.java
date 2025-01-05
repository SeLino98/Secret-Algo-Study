import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int tableSize = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        char [] list = br.readLine().toCharArray();
        boolean [] isEat = new boolean[tableSize];
        for (int i = 0; i < list.length; i++) { //사람은 true로 바꾼다.
            if (list[i] == 'P') isEat[i] = true;
        }

        int answer = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i]=='P'){
                for (int j = i-k; j <= i+k; j++) {
                    if (j >= 0 && j < list.length) {
                        //범위 안에 k 값이 있는 경우
                        //불린 값을 확인해서 해당 값이 false 이면 답을 올리고 종료
                        if (!isEat[j]) {
                            isEat[j] = true;
                            answer++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }

}
