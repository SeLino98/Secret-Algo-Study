import java.util.*; 

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0; 
        int jobsSize = jobs.length;
        //정렬한다. 0번째를 오름차순으로 
        Arrays.sort(jobs,(o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        int ProcessEndPos = 0;
        int idx = 0; 
        int cnt = 0; 
        while(cnt< jobsSize){
            
            //끝나는 시간전에 값들이 있으면 넣어준다. 
            while(idx<jobsSize && jobs[idx][0]<=ProcessEndPos){
                q.add(new int[]{jobs[idx][0],jobs[idx][1]});
                idx++;
            }
            if(!q.isEmpty()){ //큐가 비어있지 않다 -> 사이값이 존재한다. 
                int[] tmpToken = q.poll(); //값을 빼고 답을 갱신 
                answer += ProcessEndPos - tmpToken[0] + tmpToken[1]; 
                ProcessEndPos += tmpToken[1];
                cnt++;
            }else{
                ProcessEndPos = jobs[idx][0];
            }
            
        }
        answer = answer/jobsSize;
        //많은 시간을 기다리면 안된다. 즉 빠른 시간이 우선인 녀석들로 시작해야됨.
        return answer;
    }
}