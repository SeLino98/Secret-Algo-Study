import java.util.*;
class Solution {
    public int solution(int N, int number) {
        //같으면 바로 정답반환
        if(number ==N) return 1;
        //8번까지니까 각 결과 값 담을 해쉬셋생성
        Set<Integer>[] results = new HashSet[9];
        for(int i=1;i<9;i++) {
            results[i] = new HashSet<>();
        }
        // 맨처음은 자기자신 뿐
        results[1].add(N);
        // N번쨰를 채우기위해 j랑 n-j번째 껄 연산
        // ex: 5번쟤 채우기위해서는 1,4 2,3 3,2 4,1 연산값들을 넣으면됨
        for(int i=2; i<9;i++) {
            for(int j=1; j<i; j++) {
                for(int x : results[j]) {
                    for(int y : results[i-j]) {
                        results[i].add(x+y);
                        results[i].add(x-y);
                        results[i].add(x*y);
                        if(x != 0 && y !=0) results[i].add(x/y);
                    }
                }
            
                results[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
                //찾으면 바로 그 횟수 리턴
                if(results[i].contains(number)) return i;
            }
        }

        //못찾았으면 -1 리턴
        
        return -1;
    }
}
