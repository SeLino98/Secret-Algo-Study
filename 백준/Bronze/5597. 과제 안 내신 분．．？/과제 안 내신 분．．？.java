import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean [] list = new boolean[31];
        for (int t = 0; t < 28; t++) {
            int donePerson = Integer.parseInt(br.readLine());
            list[donePerson] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < list.length; i++) {
            if (!list[i]) sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
}
