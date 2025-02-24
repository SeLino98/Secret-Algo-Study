import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        
        //유클리드 호제법을 사용
        int [] list = {n,m};
        Arrays.sort(list);
        
        int gcd = getGcd(list[0],list[1]);
        int lcm = (list[0]*list[1])/gcd;
        int[] answer = {gcd,lcm};
        
        return answer;
    }
    int getGcd(int n1, int n2){
        if(n1%n2==0){
            return n2;
        }
        return getGcd(n2, n1%n2);
    }
}