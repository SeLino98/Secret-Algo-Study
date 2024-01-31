import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> str = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (str.contains(name)){

            }else {
                str.add(name);
            }
        }
        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }else {
                    return o1.length() - o2.length(); //ASC
                }

            }
        });
        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
    }
}
