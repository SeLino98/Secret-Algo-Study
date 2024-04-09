import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int queSize(int getValue){
        for (int j = 0; j < deque.size(); j++) {
            if (deque.get(j)==getValue){
                return j;
            }
        }
        return -1;
    }
    static LinkedList<Integer> deque = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }//디큐 저장
        int answerCount = 0;
        for (int i = 0; i < m; i++) {
            int getValue = Integer.parseInt(st.nextToken());
            while (true){
                if (getValue== deque.getFirst()){
                    deque.pollFirst(); //값을 뺀다.
                    break;
                }
                int size = queSize(getValue);
                if (deque.size()/2>=size){
                    //찾을 값이 중앙보다 앞에 있다?
                    //큐를 뒤로 보낸다.

                    for (int j = 0; j <size; j++) {
                        int tmp = deque.pollFirst();
                        deque.addLast(tmp);
                        answerCount++;
                    }
                }else{
                    //찾을 값이 중앙보다 뒤에 있다.?
                    //큐를 앞으로 보낸다.
                    for (int j = 0; j < deque.size()-size; j++) {
                        int tmp = deque.pollLast();
                        deque.addFirst(tmp);
                        answerCount++;
                    }
                }
            }
        }
        System.out.println(answerCount);
    }
}