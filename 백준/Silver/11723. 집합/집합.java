import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int tokenSize = st.countTokens();
            String command = st.nextToken();
            int value = 0;
            if (tokenSize>1){
                value = Integer.parseInt(st.nextToken());
            }
            switch(command){
                case "add" :
                    set.add(value);
                break;
                case "remove" :
                    set.remove(value);
                    break;
                case "check" :
                    if (set.contains(value)){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle" :
                    if (set.contains(value)){
                        set.remove(value);
                    }else{
                        set.add(value);
                    }
                    break;
                case "all" :
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty" :
                    set.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}
