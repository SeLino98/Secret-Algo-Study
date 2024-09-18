import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lecCount = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        //룸의 x 좌표를 저장하는 리스트 생성 후 정렬
        ArrayList<Integer> roomList = new ArrayList<>();
        roomList.add(0); // 첫 출발 좌표
        for (int i = 0; i < lecCount; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            roomList.add(tmp);
        }
        Collections.sort(roomList);
        //차이가 큰 값을 담는 리스트 저장
        ArrayList<Integer> roomGapList = new ArrayList<>();
        for (int i = 0; i < roomList.size()-1; i++) {
            int gap = roomList.get(i+1)-roomList.get(i);
            roomGapList.add(gap);
        }
        //차이 큰 값을 내림차순으로 정렬한 후 K부터 합산 진행
        Collections.sort(roomGapList, Comparator.reverseOrder());
        int answer = 0;
        for (int i = K; i <roomGapList.size() ; i++) {
            answer+= roomGapList.get(i);
        }
        System.out.print(answer);
    }
}
