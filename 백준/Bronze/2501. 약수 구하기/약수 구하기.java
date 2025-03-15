import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        int findCount = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= value; i++) {
            if (value%i==0){
                list.add(i);
            }
        }
        if (list.size()>=findCount){
            System.out.print(list.get(findCount-1));
        }else{
            System.out.print(0);
        }


    }

}
