import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String name = st.nextToken();
        	if(name.length()>=M) {
        		hm.put(name, hm.getOrDefault(name, 0)+1);
        	}
		}
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((o1,o2)->{
        	int frequencyComparision = Integer.compare(o2.getValue(), o1.getValue());
        	if(frequencyComparision!=0) {
        		return frequencyComparision;
        	}
        	int lengthComparison = Integer.compare(o2.getKey().length(), o1.getKey().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return o1.getKey().compareTo(o2.getKey());
        });
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}