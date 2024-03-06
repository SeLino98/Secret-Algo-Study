import java.util.*;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        
        
        HashMap<String, Integer> hash = new HashMap();
        int mapSize = id_list.length;
        int[] answer = new int[mapSize];
        
        int[][] map = new int[mapSize][mapSize];
        
        for(int i = 0 ; i<id_list.length; i++){
            
            hash.put(id_list[i],i);
            
        }        
        
        for(int i = 0; i<report.length; i++){
            String []tmpList = report[i].split(" ");
            String first =  tmpList[0];
            String second = tmpList[1];
            int firstNum = hash.get(first);
            int secondNum = hash.get(second);
            if(map[firstNum][secondNum]<1 && map[firstNum][secondNum]!= 1){
                map[firstNum][secondNum] ++;       
            }
        }    
        
//         for(int i = 0; i <map[0].length; i++){
//             for(int j = 0; j<map[0].length; j++){
//             System.out.print(map[i][j]+" ");
            
//             }
//             System.out.println();
//         }
        boolean[] isChecked = new boolean[mapSize];
        int[] countCheckList = new int [mapSize];
        for(int i = 0; i <map[0].length; i++){
            int cnt = 0;
            for(int j = 0; j<map[0].length; j++){
                if(map[j][i]>0){
                    countCheckList[i] ++;
                }  
            }
        }
        for(int i= 0; i<mapSize; i++){
            if(countCheckList[i]>=k){
                isChecked[i] = true;
            }
        }
        //  for(int i = 0; i <map[0].length; i++){
        //     System.out.print(isChecked[i]+" ");
        // }
        
        for(int i = 0; i <map[0].length; i++){
            for(int j = 0; j<map[0].length; j++){
                if(isChecked[j]){
                    if(map[i][j]>0){
                        answer[i] ++;
                    }     
                }
            }
        }
        return answer;
    }
}