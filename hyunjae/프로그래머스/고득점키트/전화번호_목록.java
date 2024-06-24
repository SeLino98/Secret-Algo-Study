import java.util.Arrays;
import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean anwser = true;
        //해쉬를 이용하기위해 해쉬 셋 설정해서 해쉬셋에 각 원소들 넣기
        //해쉬셋을 이용한 이유 몇개인지 카운트 할 필요는 없으므로 해쉬맵보단 밸류값만 이용하게 해쉬셋사용
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(phone_book));
        //이제 각 원소를 돌면서
        for (String s : phone_book) {
            //각원소를 0번째, 0~1번째 인덱싱을 하면서 해쉬에 있는지 확인
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(0, i);
                //해쉬에 있다면 false 반환
                //어짜피 전체길이에서 -1까지 인덱싱해서 자기 자신이 나올 일은 없음
                if (hashSet.contains(temp)) {
                    return false;
                }
            }
        }
        return anwser;
    }
}