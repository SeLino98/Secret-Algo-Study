import java.util.*;
import java.io.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        char [] list = br.readLine().toCharArray();
        int pos = 0;
        StringBuilder tmpSb = new StringBuilder();
        StringBuilder answerSb = new StringBuilder();
        while (pos<list.length){
            char tmp = list[pos];
            if (tmp == ' '||pos== list.length-1){
                if (pos== list.length-1) tmpSb.append(tmp);
                answerSb.append(tmpSb.reverse()).append(" ");
                tmpSb = new StringBuilder();
            } else if (tmp == '<') {
                answerSb.append(tmpSb.reverse());
                tmpSb = new StringBuilder();
            }else{
                tmpSb.append(tmp);
            }
            if (tmp=='<'){
                StringBuilder tokenSb = new StringBuilder();
                while (list[pos]!='>'){
                    tokenSb.append(list[pos++]);
                }
                tokenSb.append('>');
                answerSb.append(tokenSb);
            }
            pos++;
        }
        System.out.print(answerSb);
    }
}
