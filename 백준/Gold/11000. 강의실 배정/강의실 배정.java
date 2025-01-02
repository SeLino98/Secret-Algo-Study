import java.io.*;
import java.util.*;
public class Main {
    static class ClassInfo implements Comparable<ClassInfo>{
        int startPos = 0;
        int endPos = 0;
        public ClassInfo(int startPos,int endPos){
            this.startPos = startPos;
            this.endPos = endPos;
        }
        @Override
        public int compareTo(ClassInfo o) {
            return this.startPos-o.startPos;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalClass = Integer.parseInt(br.readLine());
        StringTokenizer st ;

        ClassInfo [] list = new ClassInfo[totalClass];
        for (int i = 0; i < totalClass; i++) {//큐 삽입
            st = new StringTokenizer(br.readLine());
            int firstPos = Integer.parseInt(st.nextToken());
            int secondPos = Integer.parseInt(st.nextToken());
            list[i] = new ClassInfo(firstPos,secondPos);
        }
        Arrays.sort(list);//리스트를 정렬한다. 강의 시작 기준을 기점으로
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //큐가 없어질 때 까지 꺼낸다.
        for (ClassInfo listToken: list) {
            if (!q.isEmpty()&&q.peek()<=listToken.startPos){
                //큐에 강의를 없애고 새 강의 시작
                q.poll(); // 끝 값을 저장
            }
            q.add(listToken.endPos);
        }
        int answer = q.size();
        System.out.print(answer);
    }
}
