import java.util.*;
class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            HashMap<String,Integer> h1 = new HashMap();

            //String의 순서대로 저장해야 된다. 
            int size = friends.length;
            int giftsSize = gifts.length;
            for(int i = 0; i<size;i ++){
                h1.put(friends[i],i);
            }
            //System.out.println("h1 : " + h1);

            int [] friendsList = new int[size];
            int [][] friendsMap = new int[size][size];

            for(int i = 0; i<giftsSize;i ++){
                String people = gifts[i];
                String []person = people.split(" ");
                //0번이 주는 사람
                //1번이 받는 사람.
                //주는 사람의 값의 번호를 받고,
                //받는 사람의 값의 번호를 받고,
                int putPersonN = h1.get(person[0]);
                int getPersonN = h1.get(person[1]);
                friendsMap[putPersonN][getPersonN]++;
                //리스트에 카운팅 해준다. 
            }
           //       for(int i = 0; i<size;i ++){
           //  for(int j = 0; j<size; j++){
           //       System.out.print(friendsMap[i][j]+" ");
           //  }
           //     System.out.println();
           // }
            
            for(int i = 0; i<size;i ++){
                for(int j = i; j<size; j++){
                    if(i == j) continue;
                    if((friendsMap[j][i]==0&&friendsMap[i][j]==0)||(friendsMap[i][j]==friendsMap[j][i])){//없거나 같은 경우 
                        //선물 지수를 계산해야 된다. 
                        int rowCountA = 0;
                        int colCountA = 0;
                        int rowCountB = 0;
                        int colCountB = 0;
                        for(int k =0; k<size; k++){
                            rowCountA += friendsMap[i][k];//준 테이블 계산
                            colCountA += friendsMap[k][i];//A가 받은 테이블 계산
                            rowCountB += friendsMap[j][k];//준 테이블 계산
                            colCountB += friendsMap[k][j];//B가 받은 테이블 계산
                        }
                        int A = rowCountA - colCountA;//선물지수계산
                        int B = rowCountB - colCountB;//선물지수계산
                        if(A<B){
                            friendsList[j]++; 
                            System.out.println("gdgd");
                        }else if(A>B){
                            friendsList[i]++; 
                            System.out.println("gsgs");
                        }
                        continue;
                    }else {
                        //값이 서로 같지도 않고 줬다는 기록이 있는 경우 .
                        if(friendsMap[i][j]>friendsMap[j][i]){
                            //j입장에선 내가 더 많이 받은 것이니 줘야한다. 
                            int value = i;
                            friendsList[i]++;
                        }else{ //j입장에선 내가 더 많이 준 것이니 받아야한다. 
                            int value = j;
                            friendsList[j]++;
                        }
                    }

                }

            }
            int maxAnswer = Integer.MIN_VALUE;
            for(int i = 0; i<size; i++){
                maxAnswer = Math.max(maxAnswer,friendsList[i]);
                   // System.out.print(friendsList[i]+" ");
            }
            return maxAnswer;
        }

    }