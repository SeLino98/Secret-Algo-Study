import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // int 배열을 Integer 배열로 변환(sort이용을 위해)
        Integer[] numbersArr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numbersArr, new Comparator<Integer>() {
            //각각 합쳐서 비교해봐서 앞에두면 더 큰 것을 앞으로오게 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1.toString();
                String str2 = o2.toString();
                
                String temp1 = str1 + str2;
                String temp2 = str2 + str1;
                return temp2.compareTo(temp1);
            }
        });
        
        StringBuilder result = new StringBuilder();
        for (int num : numbersArr) {
            result.append(num);
        }
        
        // 0으로만 구성된 경우 처리
        if (result.toString().startsWith("0")) {
            return "0";
        }
        
        return result.toString();
    }
}
    