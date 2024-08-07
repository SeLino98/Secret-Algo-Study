import java.io.*;
import java.util.*;
public class Main {
    static String[] wordList = {"Zero", "One", "Two", "Three" , "Four", "Five", "Six" , "Seven", "Eight", "Nine" };
    static class Word implements Comparable<Word>{
        int number = 0;
        String Name = new String();
        public Word(int number, String name) {
            this.number = number;
            this.Name = name;
        }
        @Override
        public int compareTo(Word o) {
            return (this.Name).compareTo(o.Name);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startValue = Integer.parseInt(st.nextToken());
        int endValue = Integer.parseInt(st.nextToken());
        ArrayList<Word> list = new ArrayList<>();
        for (int i = startValue; i <= endValue ; i++) {
            if (i>=10){//99까지니까 두 숫자로 분류한다.
                //10의자리
                int tenVal = i/10;
                //1의 자리
                int oneVal = i%10;
                String tmp = wordList[tenVal]+" "+wordList[oneVal];
                list.add(new Word(i,tmp));
            }else{ //
                list.add(new Word(i,wordList[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i%10==0&&i!=0){
                sb.append("\n");
            }
            sb.append(list.get(i).number).append(" ");
        }

        System.out.println(sb.toString());
    }
}