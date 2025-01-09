import java.io.*;
import java.util.*;
public class Main {
    final static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        HashMap<String,Boolean> hashMap = inputMethod(); //입력 받는 메소드 
        ArrayList<Map.Entry<String,Boolean>> list = sortMethod(hashMap); //정렬하는 메소드 
        findMethod(list); // 리스트에서 값을 찾는 메소드 
        System.out.print(sb);// 정답 출력
    }
    static ArrayList<Map.Entry<String,Boolean>> sortMethod(HashMap<String,Boolean> hashMap){
        ArrayList<Map.Entry<String,Boolean>> list = new ArrayList<>(hashMap.entrySet());
        list.sort((e1,e2)->{
            return e2.getKey().compareTo(e1.getKey());
        });
        return list;
    }
    static void findMethod(ArrayList<Map.Entry<String,Boolean>> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getValue()){
                sb.append(list.get(i).getKey()).append("\n");
            }
        }
    }
    static HashMap<String,Boolean> inputMethod() throws IOException{
        int testCase = Integer.parseInt(br.readLine());
        HashMap<String,Boolean> hash = new HashMap<>();
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (state.equals("enter")){
                hash.put(name,true);
            }else{
                hash.put(name,false);
            }
        }
        return hash;
    }
}