import java.io.*;
import java.util.*;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int bucketCount = Integer.parseInt(st.nextToken());
        int rangeSize = Integer.parseInt(st.nextToken())*2+1;
        int maxSize = Integer.MIN_VALUE;
        int [] list = new int[2000001];
        for (int i = 0; i < bucketCount; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            list[pos] += value;
            maxSize = Math.max(pos,maxSize);
        }
        if (rangeSize>=1000000){
            int answer = 0;
            for (int token:
                 list) {
                answer+= token;
            }
            System.out.print(answer);
            return;
        }
        int currentValue = 0;
        for (int i = 0; i < rangeSize; i++) {
            currentValue += list[i];
        }
        int answer = currentValue;
        for (int i = 0; i < maxSize; i++) {
            currentValue = currentValue - list[i] + list[rangeSize+i];
            answer = Math.max(answer, currentValue);
        }
        System.out.print(answer);
    }
}
