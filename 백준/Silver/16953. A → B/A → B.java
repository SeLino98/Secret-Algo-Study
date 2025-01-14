import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        count = Integer.MAX_VALUE;
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        DFS(end,start,1);
        if (count==Integer.MAX_VALUE){
            sb.append(-1);
            //System.out.println(-1);
        }else{
            sb.append(count);
            //System.out.println(count);
        }
        System.out.println(sb);
    }
    static void DFS( long end,long save,int depth) {
        if (end<save){
            return;
        }
        if (end == save){
            if(count>depth){
                count = depth;
            }
            return;
        }
        long sum = save*2;
        DFS( end, sum, depth+1);

        long appendOne = (save*10)+1;
        DFS( end, appendOne, depth+1);
    }
}
