import java.util.*;
import java.io.*;
class Word implements Comparable<Word>{
    String name ;
    Integer count ;
    public Word(String name, Integer count ){
        this.name = name;
        this.count = count;
    }
    @Override
    public int compareTo(Word o){
        if(o.count.equals(this.count)){
            return this.name.compareTo(o.name);
        }
        return o.count-this.count;
    }
}
public class Main{
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Word> list = new ArrayList<>();

        for(int t = 0; t<testCase; t++){
            String tmpStr = br.readLine();
            boolean flag = true;
            for(int i = 0; i<list.size(); i++){

                if(list.get(i).name.equals(tmpStr)){
                    flag = false;
                    list.get(i).count ++ ;
                    break;
                }
            }
            if(flag){
                list.add(new Word(tmpStr,1));
            }

        }
        Collections.sort(list);
        System.out.print(list.get(0).name);
    }
}