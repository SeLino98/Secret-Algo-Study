class Solution {
    public int solution(int[] arr) {
        int answer = getLCM(arr);
        
        return answer;
    }
    int getLCM(int [] arr){
        
        if(arr.length==1){
            return arr[0];
        }
        
        int gcd = getGCD(arr[0],arr[1]);
        int lcm = (arr[0]*arr[1])/gcd;

        for(int i = 2; i<arr.length; i++){
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm*arr[i])/gcd;
        }
        return lcm;
    }
    int getGCD(int n1, int n2){
        if(n1%n2==0){
            return n2;
        }
        return getGCD(n2,n1%n2);
    }
}