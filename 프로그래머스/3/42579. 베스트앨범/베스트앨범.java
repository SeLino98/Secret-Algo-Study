import java.util.*;
class Music implements Comparable<Music>{
        int play = 0;
        int label = 0;
        public Music(int play, int label) {
            this.play = play;
            this.label = label;
        }
        @Override
        public int compareTo(Music o) {
            if (o.play==this.play) return this.label - o.label;
            return o.play-this.play;
        }
    }
class Solution {
    
    static public int[] solution(String[] genres, int[] plays) {
        //1 해시 변환
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i<genres.length; i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i],map.size());
            }
        }
        //2 변환 값과 어레이 매칭
        ArrayList<ArrayList<Music>>list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            list.add(new ArrayList<>());
        }
        int[][] totalList = new int[map.size()][2];
        //3 어레이에 담기, 총합점수 담기
        for (int i = 0; i < plays.length; i++) {
            String labeling = genres[i];
            list.get(map.get(labeling)).add(new Music(plays[i],i));
            totalList[map.get(labeling)][0] += plays[i];//0번은 total
            totalList[map.get(labeling)][1] = map.get(labeling); //원래 값.
        }
        //총합 점수 정렬
        Arrays.sort(totalList,(o1, o2) -> o2[0]-o1[0]);
        //담긴 값들을 기준으로 정렬
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        //4 출력 값 변환
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < totalList.length; i++) {
            if (list.get(totalList[i][1]).size()>1){
                answerList.add(list.get(totalList[i][1]).get(0).label);
                answerList.add(list.get(totalList[i][1]).get(1).label);
            }else{
                answerList.add(list.get(totalList[i][1]).get(0).label);
            }
        }
        int []answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}