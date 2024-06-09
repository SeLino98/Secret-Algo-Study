import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            list = new LinkedList<>();
            int count = Integer.parseInt(br.readLine().trim());//암호문 갯수
            st =new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < count; i++) {//암호문 뭉치
                list.add(Integer.parseInt(st.nextToken()));
            }
            int commandCount = Integer.parseInt(br.readLine().trim());//명령어 갯수
            st = new StringTokenizer(br.readLine().trim());//명령어
            for (int i = 0; i < commandCount; i++) {
                String commandStr = st.nextToken();
                int x, y;
                switch (commandStr){
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            int value = Integer.parseInt(st.nextToken());
                            list.add(x+j,value);
                        }
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.remove(x+j);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for (int s = 0; s < y; s++) {
                            int value = Integer.parseInt(st.nextToken());
                            list.add(value);
                        }
                        break;
                }
            }
            sb.append("#").append(t).append(" ");
            for (int j = 0; j < 10; j++) {
                sb.append(list.get(j)+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
