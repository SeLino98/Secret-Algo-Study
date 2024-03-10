import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //6550번
    static String str ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while ((str = br.readLine()) != null){
            st = new StringTokenizer(str);
            char [] listS = st.nextToken().toCharArray();
            char [] listT = st.nextToken().toCharArray();
            boolean [] isCheckList = new boolean[listS.length];
            int point = 0;
            for (int i = 0; i < listS.length; i++) {
                boolean isFind = false ;
                while (!isFind){
                    if(point>=listT.length) break;
                    if(listT[point]==listS[i]){
                        //찾음
                        isCheckList[i] = true;
                        isFind = true;
                        point++;
                    }else{
                        //찾지 못함
                        point++;
                    }
                }
            }
            boolean answer  = true;
            for (int i = 0; i < isCheckList.length; i++) {
                if(!isCheckList[i])  answer = false;
            }
            if (answer){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
