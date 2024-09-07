import java.util.*;
import java.io.*;
class Series implements Comparable<Series>{
    String name = "";
    char [] nameList = name.toCharArray();
    int size =0;
    @Override
    public int compareTo(Series o) {
        if (this.size==o.size){
            int total = 0 ;
            int oTotal = 0;
            for (int i = 0; i < size; i++) {
                if (Character.isDigit(nameList[i])) {
                    total += Character.getNumericValue(nameList[i]);
                }
                if (Character.isDigit(o.nameList[i])) {
                    oTotal += Character.getNumericValue(o.nameList[i]);
                }
            }
            if (total != oTotal) {
                return total - oTotal;
            }
            return this.name.compareTo(o.name);
        }
        return this.size-o.size;
    }
    public Series(String name, char[] nameSize, int size) {
        this.name = name;
        this.nameList = nameSize;
        this.size = size;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Series> list = new ArrayList<>();
        for (int t = 0; t < testCase; t++) {
            String str = br.readLine();
            char[] nameList = str.toCharArray();
            int size = nameList.length;
            list.add(new Series(str,nameList,size));
        }
        Collections.sort(list);
        for (Series token: list
             ) {
            sb.append(token.name).append('\n');
        }
        System.out.println(sb);
    }
}
