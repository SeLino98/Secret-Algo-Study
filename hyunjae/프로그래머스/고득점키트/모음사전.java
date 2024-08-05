class Solution {
    static int answer;
    static char[] order = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        answer = 0;
        dfs(word, new StringBuilder());
        return answer;
    }
    
    private boolean dfs(String word, StringBuilder sb) {
        //한번 찾을때 마다 순서+1
        if (sb.length() > 0) {
            answer++;
            //답 찾았으면 끝
            if (word.equals(sb.toString())) {
                return true;
            }
        }
        
        //최대 5글자이므로 넘어가면 컷
        if (sb.length() == 5) {
            return false;
        }
        
        for (char ch : order) {
            sb.append(ch);
            if (dfs(word, sb)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1); // 백트래킹
        }
        
        return false;
    }
}