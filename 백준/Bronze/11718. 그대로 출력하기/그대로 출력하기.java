import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      
//        while ((str = br.readLine()) != null){
//            System.out.println(str);
//        }
        while (true){
            String str= br.readLine();
            if (str==null||str.isEmpty()){
                break;
            }
            sb.append(str).append("\n");
        }
        br.close();
        System.out.print(sb);

    }
}
