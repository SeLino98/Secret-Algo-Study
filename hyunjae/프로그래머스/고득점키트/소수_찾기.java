import java.util.*;
class Solution {
    //만들수 있는 숫자들 담을 set
    static Set<String> numList = new HashSet<>();
    //순열할 때 사용체크 표시
    static boolean[] used;
    // 밑에 소수판별배열 만들 떄 필요한 크기 구하는 용
    static int maxValue = 0;
    //소수판별배열만들기(여러 수 바로 소수인지 확인하기 용)
    static boolean[] sosuCheck;
    
    public int solution(String numbers) {
        int answer = 0;
        int n = numbers.length();
        used = new boolean[n];
        for(int i=0; i<n; i++){
            //시작이 0인건 거르기
            if(numbers.charAt(i)=='0'){
                continue;
            }
            used[i] = true;
            permutations(new StringBuilder(String.valueOf(numbers.charAt(i))), numbers, n);
            used[i] = false;
        }

        //가능한 숫자들 다 구했으면 소수판별배열 만들기
        sosuCheck = new boolean[maxValue+1];
        Arrays.fill(sosuCheck, true); 
        //0과1은 소수가 아니므로 false하고시작
        sosuCheck[0] = false;
        sosuCheck[1] = false;
        checkSosu();
        
        //숫자하나씩돌면서 소수인지 아닌지 보기
        for(String num:numList){
            if(sosuCheck[Integer.parseInt(num)]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    //순열로 간으한 숫자 뽑을 함수
    public void permutations(StringBuilder sb, String str, int n){
        //지금 sb에 들어가 있는거 뽑기
        String tempStr = sb.toString();
        
        //이건 위의 배열크기 구하는 숫자 빨리 구하기 위해 수행
        if(Integer.parseInt(tempStr)> maxValue){
            maxValue = Integer.parseInt(tempStr);
        }
        
        //이미 셋에 들어가있는 숫자면 가지치기
        if (numList.contains(tempStr)) {
            return;
        }
        //가지쳐도 남은애는 세트에 넣기
        numList.add(tempStr);
        
        //길이가 다 된 함수는 가지치기
        if(tempStr.length() ==n) {
            return;
        }
            
        
        for(int i=0; i<n; i++) {
            //쓰고 있는거는 넘어가고
            if(used[i]) continue;
            //sb에 추가하면서 used 체크
            sb.append(str.charAt(i));
            used[i] = true;
            permutations(sb, str, n);
            //재귀돌고 used에도 뺴주고 sb에도 빼주기
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    //소수판별하는 배열
    //한가지 수가 아니라 여러가지 수를 판별해야하기 때문에 미리 해놓는게 빠르다고 생각
    public void checkSosu(){
        //i를 증가시켜가면서 소수보기
        for(int i = 2; i * i <= maxValue; i++) {
            if(sosuCheck[i]) {
                //i의 배수면 다 false처리
                for(int j = i*i; j <= maxValue; j += i){
                    sosuCheck[j] = false;
                }
            }
        }
        
    }
    
}