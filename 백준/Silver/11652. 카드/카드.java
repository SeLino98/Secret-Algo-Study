import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hashMap = new HashMap<>();

        for (int t = 0; t < testCase; t++) {
            Long tempValue = Long.valueOf(br.readLine());
            if (hashMap.containsKey(tempValue)){
                hashMap.replace(tempValue,hashMap.get(tempValue)+1);
            }else{
                hashMap.put(tempValue,1);
            }
        }
        Long answer = Long.MAX_VALUE;
        int a = Collections.max(hashMap.values());
        for (Long key: hashMap.keySet()) {
            if (hashMap.get(key)== a){
                answer = Math.min(key,answer);
            }
        }
        System.out.println(answer);
//        System.out.println(hashMap);
    }
}
//                hashMap.computeIfPresent(tempValue,(k,v)->(hashMap.get(tempValue).intValue()+1));