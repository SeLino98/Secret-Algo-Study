import java.util.*;
import java.io.*;
public class Main {
    static class PowerInfo{
        String name = "";
        int power = 0;
        public PowerInfo(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int infoSize, userSize;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        infoSize = Integer.parseInt(st.nextToken());
        userSize = Integer.parseInt(st.nextToken());

        ArrayList<PowerInfo> list = new ArrayList<>();
        for (int i = 0; i < infoSize; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            if (i==0){
                list.add(new PowerInfo(name,0));
            }
            list.add(new PowerInfo(name,power));
            if (i==infoSize-1){
                list.add(new PowerInfo(name,power+1));
            }
        }//자동 정렬

        for (int i = 0; i < userSize; i++) {
            int tmpPower = Integer.parseInt(br.readLine());
            int lt = 0;
            int rt = list.size()-1;
            while (lt<=rt){
                int midPos = lt+(rt-lt)/2;
                if (list.get(midPos).power<tmpPower){//midPos 값올리기
                    lt = midPos+1;
                }else{//midPos 값 내리기
                    rt = midPos-1;
                }
            }
            sb.append(list.get(lt).name).append('\n');
        }
        System.out.print(sb);
    }
}
