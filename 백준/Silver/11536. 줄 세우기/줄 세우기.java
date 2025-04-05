import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> tmpList = new ArrayList<>();
        for (int t = 1; t <= total; t++) {
            String tmpName = br.readLine();
            list.add(tmpName);
            tmpList.add(tmpName);
        }
        Collections.sort(list);
        boolean isIncrease = true;
        boolean isDecrease = true;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(tmpList.get(i))){
                isIncrease = false;
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(list.size()-1-i).equals(tmpList.get(i))){
                isDecrease = false;
                break;
            }
        }

        if (isDecrease||isIncrease){
            if (isIncrease){
                System.out.println("INCREASING");
            }else{
                System.out.println("DECREASING");
            }
        }else{
            System.out.println("NEITHER");
        }
    }
}
