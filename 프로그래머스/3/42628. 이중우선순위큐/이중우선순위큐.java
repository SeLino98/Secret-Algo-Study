import java.util.*;
 class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            //1 우선 순위 2개 준비
            PriorityQueue<Integer> qAsc = new PriorityQueue<>();
            PriorityQueue<Integer> qDes = new PriorityQueue<>(Collections.reverseOrder());

            //2 operations의 길이만큼 for문
            // +1이면 내림차순으로 지정한 우선순위큐에서 뺀다.
            for (String operation : operations) {
                String[] str = operation.split(" ");
                switch (str[0]) {
                    case "I":
                        qAsc.add(Integer.parseInt(str[1]));
                        qDes.add(Integer.parseInt(str[1]));
                        break;
                    case "D":
                        // -1이면 오름차순으로 정렬된 우선순위 큐에서 뺀다
                        if (Integer.parseInt(str[1]) == -1) {
                            if (qAsc.size()!=0){
                                int tmp = qAsc.poll();
                                qDes.remove(tmp);//낮은 수가 우선순위
                            }
                        } else {
                            if (qDes.size()!=0){
                                int tmp = qDes.poll();
                                qAsc.remove(tmp);
                            }
                        }
                        break;
                }
            }
            if (qAsc.size()==0 || qDes.size()==0){
                answer[0] = 0;
                answer[1] = 0;
            }else{
                answer[0] = qDes.peek();
                answer[1] = qAsc.peek();
            }
            return answer;
    }
}
